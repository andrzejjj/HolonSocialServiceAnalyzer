package operation.factory;

import java.util.Date;

import operation.Operation;
import operation.OperationFactory;
import operation.operationImpl.CommentCountPerUserOperation;

public class CommentCountPerUserOperationFactory extends OperationFactory {

	@Override
	public Operation createOperation(Date from, Date to) {
		return new CommentCountPerUserOperation();
	}

}
