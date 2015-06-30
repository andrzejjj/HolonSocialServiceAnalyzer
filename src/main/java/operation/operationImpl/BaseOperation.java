package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.Operation;
import operation.UserInformation;

public abstract class BaseOperation implements Operation {

	protected void setUser(UserInformation userInformation, MessageHolder messageHolder) {
		messageHolder.setUser(userInformation.getUserName());
	}
}
