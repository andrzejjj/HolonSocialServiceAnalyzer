package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.TitleLengthSumOperation;
import operation.reducerImpl.SumReducer;

public class TitleLengthSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleLengthSumOperation();
	}

	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}
