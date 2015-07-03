package operation.transformerImpl;

import hssa.dto.MessageHolder;
import operation.Transformer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lee on 2015-07-03.
 */
public class ExtractInnerListTransformer implements Transformer {
    @Override
    public List<MessageHolder> transform(List<MessageHolder> results) {
        List<MessageHolder> all = new LinkedList<MessageHolder>();
        for (MessageHolder result : results) {
            List<Object> innerList = (List<Object>) result.getValue();
            for (Object innerListValue : innerList) {
                MessageHolder messageHolder = new MessageHolder();
                messageHolder.setUser(result.getUser());
                messageHolder.setValue(innerListValue);
                all.add(messageHolder);
            }
        }
        return all;
    }
}
