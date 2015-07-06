package operation.operationImpl;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class PostAverageLengthPerUserOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public PostAverageLengthPerUserOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		sum += calculateTitlePostsTotalLength(userInformation);
		sum += calculateCommentPostTotalLength(userInformation);
		
		int count = calculateCountOfAllPosts(userInformation);
		if (count != 0)
			messageHolder.setValue(new Double(sum / count));
		else
			messageHolder.setValue(new Double(0));
		return messageHolder;
	}

	private int calculateCountOfAllPosts(UserInformation userInformation) {
		long titlePostCount = userInformation.getTitlePosts(from, to).size();
		long commentPostCount = userInformation.getCommentPosts(from, to).size();
		return (int) (titlePostCount + commentPostCount);
	}

	private int calculateCommentPostTotalLength(UserInformation userInformation) {
		return userInformation.getCommentPosts(from, to).stream()
				.mapToInt(commentPost -> commentPost.getContent().length())
				.sum();
	}

	private int calculateTitlePostsTotalLength(UserInformation userInformation) {
		return userInformation.getTitlePosts(from, to).stream()
				.mapToInt(titlePost -> titlePost.getContent().length())
				.sum();
	}

}
