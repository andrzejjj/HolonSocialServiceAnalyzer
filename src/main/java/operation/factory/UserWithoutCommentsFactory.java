package operation.factory;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentCountPerUserOperation;
import operation.transformerImpl.FilterResultTransformer;

import java.util.Date;

/**
 * Created by lee on 2015-07-03.
 */
public class UserWithoutCommentsFactory extends OperationFactory {
    @Override
    public Operation createOperation(Date from, Date to) {
        return new CommentCountPerUserOperation();
    }

    @Override
    public Transformer createTransformer() {
        return new FilterResultTransformer(
                messageHolder -> (Double)messageHolder.getValue() == 0
        );
    }

}
