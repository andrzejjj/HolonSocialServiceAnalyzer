package hssa.agent;

import hssa.domain.AbstractPost;
import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;

import java.util.ArrayList;
import java.util.List;

import operation.Operation;
import operation.UserInformation;

import org.janusproject.kernel.address.AgentAddress;
import org.janusproject.kernel.agent.Agent;
import org.janusproject.kernel.mailbox.Mailbox;
import org.janusproject.kernel.message.Message;
import org.janusproject.kernel.message.ObjectMessage;
import org.janusproject.kernel.status.Status;

public class UserAgent extends Agent implements UserInformation {
	
		private List<TitlePost> titlePosts = new ArrayList<TitlePost>();
		private List<CommentPost> commentPosts = new ArrayList<CommentPost>();
		
		public UserAgent(AgentAddress address) {
			super(address);
		}
		
		public List<TitlePost> getTitlePosts() {
			return titlePosts;
		}
		
		public List<CommentPost> getCommentPosts() {
			return commentPosts;
		}
		
		public String getUserName() {
			if (getTitlePosts().size() != 0)
				return getTitlePosts().get(0).getAuthor();
			if (getCommentPosts().size() != 0)
				return getCommentPosts().get(0).getAuthor();
			
			return "undefined";
		}
		
		public Status activate(Object... parameters) {
			Status status = super.activate(parameters);
			return status;
		}
		
		public Status live() {
			Mailbox box = this.getMailbox();
			while (this.hasMessage()) {
				Message message = box.removeFirst();
				if (message instanceof ObjectMessage)
				{
					ObjectMessage objectMessage = (ObjectMessage) message;
					Object content = objectMessage.getContent();
					if (content instanceof AbstractPost)
						AddPost((AbstractPost) content);	
					else if (content instanceof Operation)
						ProcessOperation((Operation) content, message);
				}
			}
			
			return null;
		}

		private void AddPost(AbstractPost post) {
			if (post instanceof TitlePost)
				getTitlePosts().add((TitlePost) post);
			else if (post instanceof CommentPost)
				getCommentPosts().add((CommentPost) post);
		}
		
		private void ProcessOperation(Operation operation, Message message) {
			MessageHolder messageHolder = operation.execute(this);
			ObjectMessage objectMessage = new ObjectMessage(messageHolder);
			sendMessage(objectMessage, (AgentAddress)message.getSender());
		}
}
