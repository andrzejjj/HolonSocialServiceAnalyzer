package operation;

import java.util.Date;

import operation.factory.*;
import operation.reducerImpl.BaseReducer;

public abstract class OperationFactory {
	public static OperationFactory getFactory(OperationType operationType) {
		switch (operationType) {
		case USER_COUNT:
			return new UserCountOperationFactory();
		case POST_COUNT_PER_USER:
			return new PostCountPerUserOperationFactory();
		case POST_SUM:
			return new PostSumOperationFactory();
		case POST_AVERAGE_COUNT:
			return new PostAverageCountOperationFactory();
		case POST_AVERAGE_LENGTH_PER_USER:
			return new PostAverageLengthPerUserOperationFactory();
		case POST_AVERAGE_LENGTH:
			return new PostAverageLengthOperationFactory();
		case POST_LENGTH_SUM:
			return new PostLengthSumOperationFactory();
		case COMMENT_COUNT_PER_USER:
			return new CommentCountPerUserOperationFactory();
		case COMMENT_SUM:
			return new CommentSumOperationFactory();
		case COMMENT_AVERAGE_COUNT:
			return new CommentAverageCountOperationFactory();
		case COMMENT_AVERAGE_LENGTH_PER_USER:
			return new CommentAverageLengthPerUserOperationFactory();
		case COMMENT_AVERAGE_LENGTH:
			return new CommentAverageLengthOperationFactory();
		case COMMENT_LENGTH_SUM:
			return new CommentLengthSumOperationFactory();
		case COMMENT_AVERAGE_COUNT_PER_POST_PER_USER:
			return new CommentAverageCountPerPostPerUserFactory();
		case TITLE_COUNT_PER_USER:
			return new TitleCountPerUserOperationFactory();
		case TITLE_SUM:
			return new TitleSumOperationFactory();
		case TITLE_AVERAGE_COUNT:
			return new TitleAverageCountOperationFactory();
		case TITLE_AVERAGE_LENGTH_PER_USER:
			return new TitleAverageLengthPerUserOperationFactory();
		case TITLE_AVERAGE_LENGTH:
			return new TitleAverageLengthOperationFactory();
		case TITLE_LENGTH_SUM:
			return new TitleLengthSumOperationFactory();
		}

		return null;
	}

	public abstract Operation createOperation(Date from, Date to);
	
	public Reducer createReducer() {
		return new BaseReducer();
	}
}
