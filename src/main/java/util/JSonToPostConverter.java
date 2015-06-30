package util;

import hssa.domain.CommentPost;
import hssa.domain.TitlePost;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

public class JSonToPostConverter {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	public static TitlePost ConvertTitlePost(Document doc) {
		TitlePost titlePost = new TitlePost();

		titlePost.setAuthor(doc.get("author").toString());
		titlePost.setTitle(doc.get("title").toString());
		titlePost.setContent(doc.get("mainContent").toString());
		titlePost.setLink(doc.get("link").toString());
		
		ObjectId id = (ObjectId) doc.get("_id");
		titlePost.setId(id.toString());
		
		String dateString = doc.get("created").toString();
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		titlePost.setCreationDate(date);
		
		ArrayList<Document> comments = (ArrayList<Document>)doc.get("comments");
		for(Document commentDoc : comments) {
			CommentPost commentPost = ConvertCommentPost(commentDoc);
			commentPost.setTitlePost(titlePost);
			titlePost.getComments().add(commentPost);
		}
		
		return titlePost;
	}
	
	public static CommentPost ConvertCommentPost(Document doc) {
		CommentPost commentPost = new CommentPost();

		commentPost.setAuthor(doc.get("author").toString());
		commentPost.setTitle(doc.get("title").toString());
		commentPost.setContent(doc.get("content").toString());
		commentPost.setReceiver(doc.get("receiver").toString());
		
		//String dateString = doc.get("created").toString();
		Date date = null;
//		try {
//			date = formatter.parse(dateString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		commentPost.setCreationDate(date);
			
		return commentPost;
	}
}
