package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.Operation;
import operation.UserInformation;

import java.util.Date;

/**
 * Created by lee on 2015-07-02.
 */
public class CommentAverageCountPerPostPerUserOperation implements Operation {
    private final Date from;
    private final Date to;

    public CommentAverageCountPerPostPerUserOperation(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public MessageHolder execute(UserInformation userInformation) {
        MessageHolder messageHolder = new MessageHolder();
        messageHolder.setUser(userInformation.getUserName());
        if (userInformation.getTitlePosts(from, to).size() > 0) {
            long countOfAllPostComments = userInformation.getTitlePosts(from, to).stream()
                            .mapToInt(titlePost -> titlePost.getComments().size())
                            .sum();
            double averageCountOfCommentsPerPost =
                    countOfAllPostComments / userInformation.getTitlePosts(from, to).size();
            messageHolder.setValue(new Double(averageCountOfCommentsPerPost));
        } else messageHolder.setValue(new Double(0));
        return messageHolder;
    }
}
