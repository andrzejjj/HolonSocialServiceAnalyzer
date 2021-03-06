package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentAverageLengthPerUserOperation;
import operation.transformerImpl.SortTransformer;

public class CommentAverageLengthPerUserOperationFactory extends
		OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentAverageLengthPerUserOperation(from, to);
	}

	@Override
	public Transformer createTransformer() {
		return new SortTransformer();
	}
}
