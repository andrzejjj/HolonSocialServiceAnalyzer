package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentAverageLengthOperation;
import operation.transformerImpl.AverageReduceTransformer;

public class CommentAverageLengthOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentAverageLengthOperation();
	}
	
	@Override
	public Transformer createTransformer() {
		return new AverageReduceTransformer();
	}
}
