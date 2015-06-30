package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.PostLengthSumOperation;
import operation.reducerImpl.SumReducer;

public class PostLengthSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostLengthSumOperation();
	}

	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}