package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.PostSumOperation;
import operation.reducerImpl.SumReducer;

public class PostSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new PostSumOperation();
	}

	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}
