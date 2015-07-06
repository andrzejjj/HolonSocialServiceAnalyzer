package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.PostAverageLengthPerUserOperation;
import operation.transformerImpl.SortTransformer;

public class PostAverageLengthPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostAverageLengthPerUserOperation(from, to);
	}

	@Override
	public Transformer createTransformer() {
		return new SortTransformer();
	}
}
