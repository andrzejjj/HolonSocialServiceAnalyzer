package operation.transformerImpl;

import hssa.dto.MessageHolder;

import java.util.Collections;
import java.util.List;

import operation.Transformer;

public class SortTransformer implements Transformer {

	@Override
	public List<MessageHolder> transform(List<MessageHolder> results) {
		Collections.sort(results, new MessageHolder.DoubleComparator());
		return results;
	}

}
