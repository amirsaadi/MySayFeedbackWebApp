package com.amir.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Amir on 2017-02-18.
 * MySayFeedbackWebApp
 */


public class Comment {
	
	private int commentId;
	private String mess;
	private User user;
	private Topic commentOnTopic;
	private LocalDate date;
	
	public Comment(String mess) {
		this.mess = mess;
		this.date = LocalDate.now();
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
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
