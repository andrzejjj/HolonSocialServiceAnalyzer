package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.TitleAverageLengthOperation;
import operation.transformerImpl.AverageReduceTransformer;

public class TitleAverageLengthOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleAverageLengthOperation();
	}
	
	@Override
	public Transformer createTransformer() {
		return new AverageReduceTransformer();
	}
}
