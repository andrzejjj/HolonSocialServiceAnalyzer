package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.UserInformation;

public class TitleSumOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		int count = userInformation.getTitlePosts().size();
		
		messageHolder.setValue(new Double(count));
		return messageHolder;
	}

}
