package hssa.agent;

import hssa.AgentManager.AgentInteractionHolder;
import hssa.domain.AbstractPost;
import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import operation.OperationFactory;
import operation.Transformer;

import org.bson.Document;
import org.janusproject.kernel.address.AgentAddress;
import org.janusproject.kernel.agent.Agent;
import org.janusproject.kernel.crio.core.AddressUtil;
import org.janusproject.kernel.mailbox.Mailbox;
import org.janusproject.kernel.message.Message;
import org.janusproject.kernel.message.ObjectMessage;
import org.janusproject.kernel.status.Status;

import util.JSonToPostConverter;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MainAgent extends Agent {

	private Map<String, AgentAddress> userAgents = new HashMap<String, AgentAddress>();
	private boolean listening = false;
	private Context context;

	public MainAgent(AgentAddress address) {
		super(address);
	}

	public Status activate(Object... parameters) {
		Status status = super.activate(parameters);

		// MongoCredential credential =
		// MongoCredential.createMongoCRCredential("election_agents",
		// "election_agents", "election_agents".toCharArray());
		// MongoClient mongoClient = new MongoClient(new
		// ServerAddress("ds031932.mongolab.com:31932"),
		// Arrays.asList(credential));
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("election_agents");
		MongoCollection<Document> collection = db.getCollection("News");
		MongoCursor<Document> cursor = collection.find().iterator();

		CreateUserAgents(cursor);
		System.out.println(userAgents.size());

		return status;
	}

	public Status live() {

		if (!listening)
			waitForOperation();
		else 
			processOperation();
		
		return null;
	}

	private void waitForOperation() {
		Mailbox box = this.getMailbox();
		if (hasMessage()) {
			Message message = box.removeFirst();
			if (message instanceof ObjectMessage) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				AgentInteractionHolder agentInteractionHolder = (AgentInteractionHolder) objectMessage
						.getContent();
				OperationFactory operationFactory = OperationFactory.getFactory(agentInteractionHolder.getOperation());
				ObjectMessage sendMessage = new ObjectMessage(operationFactory.createOperation(null, null));
				broadcastMessage(sendMessage, userAgents.values());
				List<MessageHolder> holders = new ArrayList<MessageHolder>(
						userAgents.size());
				int counter = userAgents.size();
				context = new Context(agentInteractionHolder, counter,
						holders);
				listening = true;
			}
		}
	}
	
	private void processOperation() {
		if (context.counter > 0) {
			Mailbox box = this.getMailbox();
			if (hasMessage()) {
				Message message = box.removeFirst();
				if (message instanceof ObjectMessage) {
					ObjectMessage objectMessage = (ObjectMessage) message;
					context.holders.add((MessageHolder) objectMessage.getContent());
					context.counter--;
				}
			}
		}

		if (context.counter == 0) {
			OperationFactory operationFactory = OperationFactory.getFactory(context.agentInteractionHolder.getOperation());
			Transformer transformer = operationFactory.createTransformer();
			context.holders = transformer.transform(context.holders);
			context.agentInteractionHolder.setHolders(context.holders);
			context.agentInteractionHolder.endInteraction();

			listening = false;
		}
	}

	private void CreateUserAgents(MongoCursor<Document> cursor) {
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			TitlePost titlePost = JSonToPostConverter.ConvertTitlePost(doc);
			CreateUserAgents(titlePost);
		}
	}

	private void CreateUserAgents(TitlePost titlePost) {
		CreateUserAgent(titlePost);
		for(CommentPost commentPost : titlePost.getComments())
			CreateUserAgent(commentPost);
	}
	
	private void CreateUserAgent(AbstractPost abstractPost) {
		if (!userAgents.containsKey(abstractPost.getAuthor())) {
			UUID uuid = UUID.randomUUID();
			AgentAddress address = AddressUtil.createAgentAddress(uuid);
			UserAgent userAgent = new UserAgent(address);
			launchLightAgent(userAgent);

			userAgents.put(abstractPost.getAuthor(), address);
		}

		AgentAddress agentAddress = userAgents.get(abstractPost.getAuthor());
		Message message = new ObjectMessage(abstractPost);
		sendMessage(message, agentAddress);
	}

	public void executeOperation(AgentInteractionHolder agentInteractionHolder) {
		Message message = new ObjectMessage(agentInteractionHolder);
		sendMessage(message, getAddress());
	}

	private class Context {
		public List<MessageHolder> holders;
		public int counter;
		public AgentInteractionHolder agentInteractionHolder;

		public Context(AgentInteractionHolder agentInteractionHolder,
				int counter, List<MessageHolder> holders) {
			this.agentInteractionHolder = agentInteractionHolder;
			this.counter = counter;
			this.holders = holders;
		}
	}
}
