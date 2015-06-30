package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.CommentAverageCountOperation;
import operation.reducerImpl.AverageReducer;

public class CommentAverageCountOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentAverageCountOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new AverageReducer();
	}
}
