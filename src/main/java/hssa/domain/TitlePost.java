package hssa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TitlePost extends AbstractPost {
	private String id;
	private String link;
	private List<CommentPost> comments;
	
	public TitlePost() {
		comments = new ArrayList<CommentPost>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<CommentPost> getComments() {
		return comments;
	}

	public List<CommentPost> getComments(Date from, Date to) {
		return comments.stream()
				.filter(commentPost ->
					from.before(commentPost.getCreationDate()) && to.after(commentPost.getCreationDate()))
				.collect(Collectors.toList());
	}

	public void setComments(List<CommentPost> comments) {
		this.comments = comments;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("id: " + id + "\n");
		sb.append("link: " + link + "\n");
		sb.append(super.toString());
		sb.append("comments:\n\n");
		for(CommentPost commentPost : comments)
			sb.append(commentPost.toString() + "\n");
		
		return sb.toString();
	}
}
