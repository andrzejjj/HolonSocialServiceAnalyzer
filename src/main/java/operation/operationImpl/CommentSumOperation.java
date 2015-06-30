package operation.operationImpl;

import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

public class CommentSumOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		int count = 0;
		for(TitlePost titlePost : userInformation.getTitlePosts()) {
			count += titlePost.getComments().size();
		}
		
		messageHolder.setDoubleValue(count);
		
		return messageHolder;
	}

}
