package operation;

import hssa.dto.MessageHolder;

import java.util.List;

public interface Reducer {
	List<MessageHolder> reduce(List<MessageHolder> results);
}
