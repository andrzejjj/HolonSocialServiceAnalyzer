package operation.operationImpl;

import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.Operation;
import operation.UserInformation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lee on 2015-07-03.
 */
public class PopularPostPerUserOperation implements Operation {
    private static final int POPULAR_POST_COMMENTS_MINIMUM_COUNT = 100;

    @Override
    public MessageHolder execute(UserInformation userInformation) {

        List<String> popularPosts = userInformation
                .getTitlePosts()
                .stream()
                .filter(titlePost ->
                        titlePost.getComments().size() > POPULAR_POST_COMMENTS_MINIMUM_COUNT)
                .map(titlePost -> titlePost.getTitle())
                .collect(Collectors.toList());

        MessageHolder messageHolder = new MessageHolder();
        messageHolder.setUser(userInformation.getUserName());
        messageHolder.setValue(popularPosts);
        return messageHolder;
    }
}
