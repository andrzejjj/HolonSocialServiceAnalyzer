package operation.transformerImpl;

import hssa.dto.MessageHolder;

import java.util.Arrays;
import java.util.List;

public class AverageReduceTransformer extends SortTransformer {
	@Override
	public List<MessageHolder> transform(List<MessageHolder> results) {
		MessageHolder messageHolder = new MessageHolder();
		
		messageHolder.setUser("œrednia");
		double sum = 0;
		for(MessageHolder result : results)
			sum += (Double)result.getValue();
		if (results.size() != 0)
			messageHolder.setValue(new Double(sum / results.size()));
		else
			messageHolder.setValue(new Double(0));
			
		return Arrays.asList(messageHolder);
	}
}
