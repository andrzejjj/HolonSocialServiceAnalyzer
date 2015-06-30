package operation.operationImpl;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

public class PostAverageLengthPerUserOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		for(TitlePost titlePost : userInformation.getTitlePosts())
			sum += titlePost.getContent().length();
		for(CommentPost commentPost : userInformation.getCommentPosts())
			sum += commentPost.getContent().length();
		
		int count = userInformation.getTitlePosts().size() + userInformation.getCommentPosts().size();
		if (count != 0)
			messageHolder.setDoubleValue(sum/count);
		else
			messageHolder.setDoubleValue(0);
		return messageHolder;
	}

}
