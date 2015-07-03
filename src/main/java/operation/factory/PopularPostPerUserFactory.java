package operation.factory;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.PopularPostPerUserOperation;
import operation.transformerImpl.ExtractInnerListTransformer;

import java.util.Date;

/**
 * Created by lee on 2015-07-03.
 */
public class PopularPostPerUserFactory extends OperationFactory {
    @Override
    public Operation createOperation(Date from, Date to) {
        return new PopularPostPerUserOperation();
    }

    @Override
    public Transformer createTransformer() {
        return new ExtractInnerListTransformer();
    }

}
