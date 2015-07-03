package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.UserCountOperation;
import operation.transformerImpl.SumReduceTransformer;

public class UserCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new UserCountOperation();
	}
	
	@Override
	public Transformer createTransformer() {
		return new SumReduceTransformer();
	}
}
