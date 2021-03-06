package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentLengthSumOperation;
import operation.transformerImpl.SumReduceTransformer;

public class CommentLengthSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentLengthSumOperation(from, to);
	}

	@Override
	public Transformer createTransformer() {
		return new SumReduceTransformer();
	}
}
