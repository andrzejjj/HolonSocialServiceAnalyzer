package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.TitleAverageCountOperation;
import operation.reducerImpl.AverageReducer;

public class TitleAverageCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleAverageCountOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new AverageReducer();
	}
}
