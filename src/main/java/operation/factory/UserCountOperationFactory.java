package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.UserCountOperation;
import operation.reducerImpl.SumReducer;

public class UserCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new UserCountOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}
