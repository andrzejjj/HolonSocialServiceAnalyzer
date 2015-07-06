package operation.operationImpl;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class PostLengthSumOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public PostLengthSumOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		for(TitlePost titlePost : userInformation.getTitlePosts(from, to))
			sum += titlePost.getContent().length();
		for(CommentPost commentPost : userInformation.getCommentPosts(from, to))
			sum += commentPost.getContent().length();
		
		int count = userInformation.getTitlePosts(from, to).size() +
				userInformation.getCommentPosts(from, to).size();
		if (count != 0)
			messageHolder.setValue(new Double(sum / count));
		else
			messageHolder.setValue(new Double(0));
		return messageHolder;
	}

}
