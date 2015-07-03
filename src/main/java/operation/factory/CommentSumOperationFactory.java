package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentSumOperation;
import operation.transformerImpl.SumReduceTransformer;

public class CommentSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentSumOperation();
	}
	
	@Override
	public Transformer createTransformer() {
		return new SumReduceTransformer();
	}
}
