package hssa.dto;

import java.util.Comparator;

public class MessageHolder {
	private String user; 
	private double doubleValue;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	public static class DoubleComparator implements Comparator<MessageHolder> {
		public int compare(MessageHolder mh1, MessageHolder mh2) {
			return Double.compare(mh2.getDoubleValue(), mh1.getDoubleValue());
		}
		
	}
}
