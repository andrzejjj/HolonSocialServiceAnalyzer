package hssa.AgentManager;

import hssa.agent.MainAgent;
import hssa.dto.MessageHolder;
import hssa.model.Result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import operation.OperationType;
import operation.OperationTypeTranslations;

import org.janusproject.kernel.Kernel;
import org.janusproject.kernel.address.AgentAddress;
import org.janusproject.kernel.agent.Kernels;
import org.janusproject.kernel.crio.core.AddressUtil;

public class AgentManager {
	
	private AgentAddress mainAgentAddress;
	private MainAgent mainAgent;
	private ExecutorService executor = Executors.newFixedThreadPool(10);

	public void init() {
		Kernel kernel = Kernels.get();

		UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-426655440000");
		mainAgentAddress = AddressUtil.createAgentAddress(uuid);
		mainAgent = new MainAgent(mainAgentAddress);
		kernel.launchHeavyAgent(mainAgent);
	}

	public Collection<String> GetAvailableMeasures() {
		return OperationTypeTranslations.getOperationtranslations().values();
	}

	public List<Result> calculateMeasure(String friendlyName) {
		OperationType operation = OperationTypeTranslations.getOperationtranslationsreversed().get(friendlyName);
		OperationCallable operationCallable = new OperationCallable(mainAgent, operation);
		Future<AgentInteractionHolder> agentInteractionHolderFuture = executor.submit(operationCallable);
		
		List<Result> results = new ArrayList<Result>();
		AgentInteractionHolder agentInteractionHolder = null;
		try {
			agentInteractionHolder = agentInteractionHolderFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		for(MessageHolder messageHolder : agentInteractionHolder.getHolders()) {
			String result1 = messageHolder.getUser().toString();
			Object result2 = messageHolder.getValue();
			results.add(new Result(result1 , result2.toString()));
		}
		
		return results;
	}
}
