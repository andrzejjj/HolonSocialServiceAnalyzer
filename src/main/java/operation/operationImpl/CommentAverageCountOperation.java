package operation.operationImpl;

import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class CommentAverageCountOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public CommentAverageCountOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		int count = 0;
		for(TitlePost titlePost : userInformation.getTitlePosts(from, to)) {
			count += titlePost.getComments(from, to).size();
		}
		
		messageHolder.setValue(new Double(count));
		
		return messageHolder;
	}

}
