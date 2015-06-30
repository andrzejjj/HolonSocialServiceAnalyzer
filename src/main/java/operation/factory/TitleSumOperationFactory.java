package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.TitleSumOperation;
import operation.reducerImpl.SumReducer;

public class TitleSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleSumOperation();
	}

	@Override
	public Reducer createReducer() {
		return new SumReducer();
	}
}
