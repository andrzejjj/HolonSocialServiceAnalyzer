package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class PostCountPerUserOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public PostCountPerUserOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		int count = userInformation.getTitlePosts(from, to).size() +
				userInformation.getCommentPosts(from, to).size();
		messageHolder.setValue(new Double(count));
		return messageHolder;
	}

}
