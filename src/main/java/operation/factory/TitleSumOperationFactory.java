package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.TitleSumOperation;
import operation.transformerImpl.SumReduceTransformer;

public class TitleSumOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleSumOperation(from, to);
	}

	@Override
	public Transformer createTransformer() {
		return new SumReduceTransformer();
	}
}
