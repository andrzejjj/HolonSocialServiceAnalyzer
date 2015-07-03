package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.PostSumOperation;
import operation.transformerImpl.SumReduceTransformer;

public class PostSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostSumOperation();
	}

	@Override
	public Transformer createTransformer() {
		return new SumReduceTransformer();
	}
}
