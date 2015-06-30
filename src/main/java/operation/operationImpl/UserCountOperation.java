package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.UserInformation;

public class UserCountOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		messageHolder.setDoubleValue(1);
		
		return messageHolder;
	}

}
