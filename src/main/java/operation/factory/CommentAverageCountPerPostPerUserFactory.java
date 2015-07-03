package operation.factory;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.CommentAverageCountPerPostPerUserOperation;
import operation.transformerImpl.SortTransformer;

import java.util.Date;

/**
 * Created by lee on 2015-07-02.
 */
public class CommentAverageCountPerPostPerUserFactory extends OperationFactory {
    @Override
    public Operation createOperation(Date from, Date to) {
        return new CommentAverageCountPerPostPerUserOperation();
    }

    @Override
    public Transformer createTransformer() {
        return new SortTransformer();
    }
}
