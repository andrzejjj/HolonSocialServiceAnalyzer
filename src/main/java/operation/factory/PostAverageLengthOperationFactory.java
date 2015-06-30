package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.PostAverageLengthOperation;
import operation.reducerImpl.AverageReducer;

public class PostAverageLengthOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostAverageLengthOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new AverageReducer();
	}
}