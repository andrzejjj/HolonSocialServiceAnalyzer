package operation.operationImpl;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class CommentLengthSumOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public CommentLengthSumOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		int count = 0;
		for(TitlePost titlePost : userInformation.getTitlePosts(from,to)) {
			count += titlePost.getComments(from, to).size();
			for(CommentPost commentPost : titlePost.getComments(from, to))
				sum += commentPost.getContent().length();
		}
		
		if (count != 0)
			messageHolder.setValue(new Double(sum / count));
		else
			messageHolder.setValue(new Double(0));
		return messageHolder;
	}

}
