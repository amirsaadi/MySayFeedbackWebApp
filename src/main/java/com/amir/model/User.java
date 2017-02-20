package com.amir.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Amir on 2017-02-17.
 * MySayFeedbackWebApp
 */

public class User {
	
	private String name;
	private String email;
	private boolean isAuthenticated;
	
	private Collection<Topic> topics= new ArrayList<>();
	private Collection<Comment> comments= new ArrayList<>();
	
	public User() {
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
		isAuthenticated=false;
	}
	
	public boolean isAuthenticated() {
		return isAuthenticated;
	}
	
	public void setAuthenticated(boolean authenticated) {
		isAuthenticated = authenticated;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Collection<Topic> getTopics() {
		return topics;
	}
	
	public void setTopics(Collection<Topic> topics) {
		this.topics = topics;
	}
	
	public Collection<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", isAuthenticated=" + isAuthenticated +
				", topics=" + topics.size() +
				", comments=" + comments.size() +
				'}';
	}
}
