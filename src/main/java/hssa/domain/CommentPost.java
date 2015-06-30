package hssa.domain;

public class CommentPost extends AbstractPost {

	private String receiver;
	private TitlePost titlePost;
	
	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("receiver: " + receiver + "\n");
		sb.append(super.toString());
		
		return sb.toString();
	}

	public TitlePost getTitlePost() {
		return titlePost;
	}

	public void setTitlePost(TitlePost titlePost) {
		this.titlePost = titlePost;
	}
}

