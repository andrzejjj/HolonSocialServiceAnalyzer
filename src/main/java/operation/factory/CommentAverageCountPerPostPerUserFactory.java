package operation.factory;

import operation.Operation;
import operation.OperationFactory;
import operation.Reducer;
import operation.operationImpl.CommentAverageCountPerPostPerUserOperation;
import operation.reducerImpl.AverageReducer;

import java.util.Date;

/**
 * Created by lee on 2015-07-02.
 */
public class CommentAverageCountPerPostPerUserFactory extends OperationFactory {
    @Override
    public Operation createOperation(Date from, Date to) {
        return new CommentAverageCountPerPostPerUserOperation();
    }
}
