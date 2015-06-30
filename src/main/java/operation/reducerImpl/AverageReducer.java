package operation.reducerImpl;

import hssa.dto.MessageHolder;

import java.util.Arrays;
import java.util.List;

public class AverageReducer extends BaseReducer {
	@Override
	public List<MessageHolder> reduce(List<MessageHolder> results) {
		MessageHolder messageHolder = new MessageHolder();
		
		messageHolder.setUser("œrednia");
		double sum = 0;
		for(MessageHolder result : results)
			sum += result.getDoubleValue();
		if (results.size() != 0)
			messageHolder.setDoubleValue(sum/results.size());
		else
			messageHolder.setDoubleValue(0);
			
		return Arrays.asList(messageHolder);
	}
}
