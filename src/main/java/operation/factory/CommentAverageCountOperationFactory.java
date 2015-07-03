package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentAverageCountOperation;
import operation.transformerImpl.AverageReduceTransformer;

public class CommentAverageCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentAverageCountOperation();
	}
	
	@Override
	public Transformer createTransformer() {
		return new AverageReduceTransformer();
	}
}
