package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentCountPerUserOperation;
import operation.transformerImpl.SortTransformer;

public class CommentCountPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentCountPerUserOperation(from, to);
	}

	@Override
	public Transformer createTransformer() {
		return new SortTransformer();
	}
}
