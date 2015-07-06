package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.PostAverageLengthOperation;
import operation.transformerImpl.AverageReduceTransformer;

public class PostAverageLengthOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostAverageLengthOperation(from, to);
	}
	
	@Override
	public Transformer createTransformer() {
		return new AverageReduceTransformer();
	}
}
