package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.CommentSumOperation;
import operation.reducerImpl.SumReducer;

public class CommentSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentSumOperation();
	}
	
	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}
