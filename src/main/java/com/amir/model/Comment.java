package com.amir.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Amir on 2017-02-18.
 * MySayFeedbackWebApp
 */


public class Comment {
	
	private int commentId;
	private String mess;
	private User user;
	private Topic commentOnTopic;
	private String date;
	
	public Comment(String mess) {
		this.mess = mess;
		this.date = getFormattedTimeDate();
	}
	
	public Comment() {
	}
	
	public int getCommentId() {
		return commentId;
	}
	
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	public String getMess() {
		return mess;
	}
	
	public void setMess(String mess) {
		this.mess = mess;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Topic getCommentOnTopic() {
		return commentOnTopic;
	}
	
	public void setCommentOnTopic(Topic commentOnTopic) {
		this.commentOnTopic = commentOnTopic;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	private String getFormattedTimeDate(){
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d','uu 'at' H:mm");
		String text = date.format(formatter);
		return   text.substring(0, 1).toUpperCase() + text.substring(1);
	}
}
