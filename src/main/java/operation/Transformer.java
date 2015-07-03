package operation;

import hssa.dto.MessageHolder;

import java.util.List;

public interface Transformer {
	List<MessageHolder> transform(List<MessageHolder> results);
}
