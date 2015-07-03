package hssa.dto;

import java.util.Comparator;

public class MessageHolder {
	private String user; 
	private Object value;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public static class DoubleComparator implements Comparator<MessageHolder> {
		public int compare(MessageHolder mh1, MessageHolder mh2) {
			return Double.compare((Double)mh2.getValue(), (Double)mh1.getValue());
		}
		
	}
}
