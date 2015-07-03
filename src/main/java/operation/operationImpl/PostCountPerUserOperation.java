package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.UserInformation;

public class PostCountPerUserOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		int count = userInformation.getTitlePosts().size() + userInformation.getCommentPosts().size();
		messageHolder.setValue(new Double(count));
		return messageHolder;
	}

}
