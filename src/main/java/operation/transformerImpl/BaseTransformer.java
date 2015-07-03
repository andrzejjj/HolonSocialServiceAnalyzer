package operation.transformerImpl;

import hssa.dto.MessageHolder;
import operation.Transformer;

import java.util.Collections;
import java.util.List;

public class BaseTransformer implements Transformer {

	@Override
	public List<MessageHolder> transform(List<MessageHolder> results) {
		return results;
	}

}
