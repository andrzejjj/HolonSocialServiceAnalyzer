package operation.factory;

import operation.Operation;
import operation.OperationFactory;
import operation.Transformer;
import operation.operationImpl.FindNeighboursOperator;
import operation.transformerImpl.BaseTransformer;
import operation.transformerImpl.FindCliquesTransformer;

import java.util.Date;

/**
 * Created by lee on 2015-07-07.
 */
public class FindingCliquesFactory extends OperationFactory {
    @Override
    public Operation createOperation(Date from, Date to) {
        return new FindNeighboursOperator(from, to);
    }

    @Override
    public Transformer createTransformer() {
        return new FindCliquesTransformer();
    }
}
