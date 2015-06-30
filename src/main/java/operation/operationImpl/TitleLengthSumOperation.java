package operation.operationImpl;

import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

public class TitleLengthSumOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		int count = userInformation.getTitlePosts().size();
		for(TitlePost titlePost : userInformation.getTitlePosts()) {
			sum += titlePost.getContent().length();
		}
		
		if (count != 0)
			messageHolder.setDoubleValue(sum/count);
		else
			messageHolder.setDoubleValue(0);
		return messageHolder;
	}

}
