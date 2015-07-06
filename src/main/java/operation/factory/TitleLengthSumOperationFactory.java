package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.TitleLengthSumOperation;
import operation.transformerImpl.SumReduceTransformer;

public class TitleLengthSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleLengthSumOperation(from, to);
	}

	@Override
	public Transformer createTransformer() {
		return new SumReduceTransformer();
	}
}
