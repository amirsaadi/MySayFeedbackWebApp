package com.amir.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Amir on 2017-02-18.
 * MySayFeedbackWebApp
 */
public class Topic {
	private int topicId;
	private String title;
	private String content;
	private String date;
	private User user;
	private List<Comment> comments=new ArrayList<>();
	private static final AtomicInteger count = new AtomicInteger(0);
	
	public Topic() {
	}
	
	public Topic(String title, String content) {
		this.topicId=count.incrementAndGet();
		this.title = title;
		this.content = content;
		
		this.date = getFormattedTimeDate();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getTopicId() {
		return topicId;
	}
	
	private void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	private String getFormattedTimeDate(){
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d','uu 'at' H:mm");
		String text = date.format(formatter);
		return   text.substring(0, 1).toUpperCase() + text.substring(1);
	}
	
}
