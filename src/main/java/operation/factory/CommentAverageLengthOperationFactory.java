package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.CommentAverageLengthOperation;
import operation.reducerImpl.AverageReducer;

public class CommentAverageLengthOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentAverageLengthOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new AverageReducer();
	}
}
