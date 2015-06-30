package operation;

import java.util.Date;

import operation.factory.CommentAverageCountOperationFactory;
import operation.factory.CommentAverageLengthOperationFactory;
import operation.factory.CommentAverageLengthPerUserOperationFactory;
import operation.factory.CommentCountPerUserOperationFactory;
import operation.factory.CommentLengthSumOperationFactory;
import operation.factory.CommentSumOperationFactory;
import operation.factory.PostAverageCountOperationFactory;
import operation.factory.PostAverageLengthOperationFactory;
import operation.factory.PostAverageLengthPerUserOperationFactory;
import operation.factory.PostCountPerUserOperationFactory;
import operation.factory.PostLengthSumOperationFactory;
import operation.factory.PostSumOperationFactory;
import operation.factory.TitleAverageCountOperationFactory;
import operation.factory.TitleAverageLengthOperationFactory;
import operation.factory.TitleAverageLengthPerUserOperationFactory;
import operation.factory.TitleCountPerUserOperationFactory;
import operation.factory.TitleLengthSumOperationFactory;
import operation.factory.TitleSumOperationFactory;
import operation.factory.UserCountOperationFactory;
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
