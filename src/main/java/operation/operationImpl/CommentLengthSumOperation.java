package operation.operationImpl;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

public class CommentLengthSumOperation extends BaseOperation {

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		int count = 0;
		for(TitlePost titlePost : userInformation.getTitlePosts()) {
			count += titlePost.getComments().size();
			for(CommentPost commentPost : titlePost.getComments())
				sum += commentPost.getContent().length();
		}
		
		if (count != 0)
			messageHolder.setValue(new Double(sum / count));
		else
			messageHolder.setValue(new Double(0));
		return messageHolder;
	}

}
