package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class UserCountOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public UserCountOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		if (userActiveInPeriod(userInformation, from, to) )
			messageHolder.setValue(new Double(1));
		else
			messageHolder.setValue(new Double(0));
		
		return messageHolder;
	}

	private boolean userActiveInPeriod(UserInformation userInformation, Date from, Date to) {
		boolean wrotePost = userInformation.getTitlePosts(from, to).size() > 0;
		boolean wroteComments = userInformation.getCommentPosts(from, to).size() > 0;
		return wrotePost || wroteComments;
	}

}
