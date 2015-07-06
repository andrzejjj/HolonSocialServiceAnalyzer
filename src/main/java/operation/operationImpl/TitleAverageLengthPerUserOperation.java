package operation.operationImpl;

import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.UserInformation;

import java.util.Date;

public class TitleAverageLengthPerUserOperation extends BaseOperation {

	private final Date from;
	private final Date to;

	public TitleAverageLengthPerUserOperation(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public MessageHolder execute(UserInformation userInformation) {
		MessageHolder messageHolder = new MessageHolder();
		setUser(userInformation, messageHolder);
		double sum = 0;
		int count = userInformation.getTitlePosts(from, to).size();
		for(TitlePost titlePost : userInformation.getTitlePosts(from, to)) {
			sum += titlePost.getContent().length();
		}
		
		if (count != 0)
			messageHolder.setValue(new Double(sum / count));
		else
			messageHolder.setValue(new Double(0));
		return messageHolder;
	}

}
