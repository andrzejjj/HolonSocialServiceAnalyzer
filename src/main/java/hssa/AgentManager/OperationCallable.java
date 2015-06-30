package hssa.AgentManager;

import hssa.agent.MainAgent;

import java.util.concurrent.Callable;

import operation.OperationType;

public class OperationCallable implements Callable<AgentInteractionHolder> {
	
	private MainAgent mainAgent;
	private OperationType operation;
	
	public OperationCallable(MainAgent mainAgent, OperationType operation) {
		this.mainAgent = mainAgent;
		this.operation = operation;
	}
	
	@Override
	public AgentInteractionHolder call() throws Exception {
		AgentInteractionHolder agentInteractionHolder = new AgentInteractionHolder(operation);
		mainAgent.executeOperation(agentInteractionHolder);
		boolean flag = agentInteractionHolder.isFinidhed();
		while (!flag)
			flag = agentInteractionHolder.isFinidhed();
		
		return agentInteractionHolder;
	}
	
}
