package operation.reducerImpl;

import hssa.dto.MessageHolder;

import java.util.Arrays;
import java.util.List;

public class SumReducer extends BaseReducer {
	@Override
	public List<MessageHolder> reduce(List<MessageHolder> results) {
		MessageHolder messageHolder = new MessageHolder();
		
		messageHolder.setUser("suma");
		double sum = 0;
		for(MessageHolder result : results)
			sum += result.getDoubleValue();
		messageHolder.setDoubleValue(sum);
		
		return Arrays.asList(messageHolder);
	}
}
