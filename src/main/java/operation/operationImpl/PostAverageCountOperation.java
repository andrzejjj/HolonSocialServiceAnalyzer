package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.UserInformation;

public class PostAverageCountOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		int count = userInformation.getTitlePosts().size() + userInformation.getCommentPosts().size();
		messageHolder.setDoubleValue(count);
		return messageHolder;
	}

}
