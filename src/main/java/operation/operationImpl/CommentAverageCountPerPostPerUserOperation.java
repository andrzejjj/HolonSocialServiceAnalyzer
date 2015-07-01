package operation.operationImpl;

import hssa.dto.MessageHolder;
import operation.Operation;
import operation.UserInformation;

/**
 * Created by lee on 2015-07-02.
 */
public class CommentAverageCountPerPostPerUserOperation implements Operation {
    @Override
    public MessageHolder execute(UserInformation userInformation) {
        MessageHolder messageHolder = new MessageHolder();
        messageHolder.setUser(userInformation.getUserName());
        if (userInformation.getTitlePosts().size() > 0) {
            long countOfAllPostComments =
                    userInformation
                            .getTitlePosts()
                            .stream()
                            .mapToInt(titlePost -> titlePost.getComments().size())
                            .sum();
            double averageCountOfCommentsPerPost = countOfAllPostComments / userInformation.getTitlePosts().size();
            messageHolder.setDoubleValue(averageCountOfCommentsPerPost);
        } else messageHolder.setDoubleValue(0);
        return messageHolder;
    }
}
