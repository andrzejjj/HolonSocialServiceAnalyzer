package hssa.AgentManager;

import hssa.agent.MainAgent;

import java.util.Date;
import java.util.concurrent.Callable;

import operation.OperationType;

public class OperationCallable implements Callable<AgentInteractionHolder> {

	private MainAgent mainAgent;
	private OperationType operation;
	private final Date from;
	private final Date to;
	
	public OperationCallable(MainAgent mainAgent, OperationType operation, Date from, Date to) {
		this.mainAgent = mainAgent;
		this.operation = operation;
		this.from = from;
		this.to = to;
	}
	
	@Override
	public AgentInteractionHolder call() throws Exception {
		AgentInteractionHolder agentInteractionHolder = new AgentInteractionHolder(operation, from, to);
		mainAgent.executeOperation(agentInteractionHolder);
		boolean flag = agentInteractionHolder.isFinidhed();
		while (!flag)
			flag = agentInteractionHolder.isFinidhed();
		
		return agentInteractionHolder;
	}
	
}
