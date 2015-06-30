package operation;

import hssa.dto.MessageHolder;

public interface Operation {
	
	MessageHolder execute(UserInformation userInformation); 
}
