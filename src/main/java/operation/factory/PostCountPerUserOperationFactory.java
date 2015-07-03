package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.PostCountPerUserOperation;
import operation.transformerImpl.SortTransformer;

public class PostCountPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostCountPerUserOperation();
	}

	@Override
	public Transformer createTransformer() {
		return new SortTransformer();
	}
}
