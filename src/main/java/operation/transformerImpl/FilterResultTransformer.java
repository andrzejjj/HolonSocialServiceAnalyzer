package operation.transformerImpl;

import hssa.dto.MessageHolder;
import operation.Transformer;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by lee on 2015-07-03.
 */
public class FilterResultTransformer implements Transformer {
    private final Predicate<MessageHolder> predicate;

    public FilterResultTransformer(Predicate<MessageHolder> predicate) {
        this.predicate = predicate;
    }

    @Override
    public List<MessageHolder> transform(List<MessageHolder> results) {
        return results
                .stream()
                .filter(predicate)
                .collect(Collectors.toList() );
    }
}
