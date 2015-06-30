package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.operationImpl.TitleAverageLengthPerUserOperation;

public class TitleAverageLengthPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleAverageLengthPerUserOperation();
	}

}
