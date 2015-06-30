package operation.reducerImpl;

import hssa.dto.MessageHolder;

import java.util.List;

import operation.Reducer;

public class BaseReducer implements Reducer {

	@Override
	public List<MessageHolder> reduce(List<MessageHolder> results) {
		return results;
	}

}
