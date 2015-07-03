package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.TitleCountPerUserOperation;
import operation.transformerImpl.SortTransformer;

public class TitleCountPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new TitleCountPerUserOperation();
	}

	@Override
	public Transformer createTransformer() {
		return new SortTransformer();
	}
}
