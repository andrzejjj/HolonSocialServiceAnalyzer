package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.PostAverageCountOperation;
import operation.reducerImpl.AverageReducer;

public class PostAverageCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostAverageCountOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new AverageReducer();
	}
}
