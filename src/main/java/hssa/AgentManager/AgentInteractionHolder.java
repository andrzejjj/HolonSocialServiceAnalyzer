package hssa.AgentManager;

import hssa.dto.MessageHolder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import operation.OperationType;

public class AgentInteractionHolder {
	private List<MessageHolder> holders;
	private final Date from;
	private final Date to;
	private OperationType operation;
	private boolean done;
	
	public AgentInteractionHolder(OperationType operation, Date from, Date to) {
		this.operation = operation;
		this.from = from;
		this.to = to;
		holders = new ArrayList<MessageHolder>();
		done = false;
	}
	
	public List<MessageHolder> getHolders() {
		return holders;
	}
	public void setHolders(List<MessageHolder> holders) {
		this.holders = holders;
	}
	public OperationType getOperation() {
		return operation;
	}
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}

	public Date getFrom() {
		return from;
	}

	public Date getTo() {
		return to;
	}

	public synchronized void endInteraction() {
		done = true;
		notify();
	}
	
	public synchronized boolean isFinidhed() {
		if (done)
			return true;
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
}
