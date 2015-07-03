package operation.transformerImpl;

import hssa.dto.MessageHolder;

import java.util.Arrays;
import java.util.List;

public class SumReduceTransformer extends SortTransformer {
	@Override
	public List<MessageHolder> transform(List<MessageHolder> results) {
		MessageHolder messageHolder = new MessageHolder();
		
		messageHolder.setUser("suma");
		double sum = 0;
		for(MessageHolder result : results)
			sum += (Double)result.getValue();
		messageHolder.setValue(new Double(sum));
		
		return Arrays.asList(messageHolder);
	}
}
