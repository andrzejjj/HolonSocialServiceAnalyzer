package hssa.domain;

import java.util.Date;

public class AbstractPost {
	private String title;
	private String author;
	private Date creationDate;
	private String content;
	
	public AbstractPost() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("author: " + author + "\n");
		sb.append("title: " + title + "\n");
		sb.append("creationDate: " + creationDate + "\n");
		sb.append("content: " + content + "\n");
		
		return sb.toString();
	}
}