package operation;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;

import java.util.Date;
import java.util.List;

public interface UserInformation {
	public String getUserName();
	public List<TitlePost> getTitlePosts();
	public List<TitlePost> getTitlePosts(Date from, Date to);
	public List<CommentPost> getCommentPosts();
	public List<CommentPost> getCommentPosts(Date from, Date to);
}
