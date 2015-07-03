package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.TitleAverageCountOperation;
import operation.transformerImpl.AverageReduceTransformer;

public class TitleAverageCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleAverageCountOperation();
	}
	
	@Override
	public Transformer createTransformer() {
		return new AverageReduceTransformer();
	}
}
