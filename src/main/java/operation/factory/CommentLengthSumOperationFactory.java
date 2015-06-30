package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.CommentLengthSumOperation;
import operation.reducerImpl.SumReducer;

public class CommentLengthSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentLengthSumOperation();
	}

	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}
