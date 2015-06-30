package operation;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;

import java.util.List;

public interface UserInformation {
	public String getUserName();
	public List<TitlePost> getTitlePosts();
	public List<CommentPost> getCommentPosts();
}
