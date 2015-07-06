package operation.operationImpl;

import hssa.domain.TitlePost;
import hssa.dto.MessageHolder;
import operation.Operation;
import operation.UserInformation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lee on 2015-07-07.
 */
public class FindNeighboursOperator implements Operation {

    private final Date from;
    private final Date to;

    public FindNeighboursOperator(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public MessageHolder execute(UserInformation userInformation) {
        List<String> userWhoCommented =
            userInformation.getTitlePosts(from, to).stream()
                .flatMap(titlePost -> titlePost.getComments(from, to).stream())
                .map(commentPost -> commentPost.getAuthor())
                .collect(Collectors.toList());

        MessageHolder messageHolder = new MessageHolder();
        messageHolder.setUser(userInformation.getUserName());
        messageHolder.setValue(userWhoCommented);

        return messageHolder;
    }
}
