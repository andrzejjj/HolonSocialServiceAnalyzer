package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.TitleAverageLengthOperation;
import operation.reducerImpl.AverageReducer;

public class TitleAverageLengthOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleAverageLengthOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new AverageReducer();
	}
}
