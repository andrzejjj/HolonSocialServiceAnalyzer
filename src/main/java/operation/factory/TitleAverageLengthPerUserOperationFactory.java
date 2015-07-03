package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.TitleAverageLengthPerUserOperation;
import operation.transformerImpl.SortTransformer;

public class TitleAverageLengthPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleAverageLengthPerUserOperation();
	}

	@Override
	public Transformer createTransformer() {
		return new SortTransformer();
	}
}
