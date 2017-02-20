package com.amir.services;

import com.amir.model.Comment;
import com.amir.model.Topic;
import com.amir.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Amir on 2017-02-18.
 * MySayFeedbackWebApp
 * Class mimics a database
 */
public class DataService {
	
	private ArrayList<User> users;
	private ArrayList<Topic> topics;
	private ArrayList<Comment> comments;
	
	public DataService() {
		users = new ArrayList<User>() {{
			add(new User("user 1", "emil 1"));
			add(new User("user 2", "emil 2"));
			add(new User("user 3", "emil 3"));
			add(new User("user 4", "emil 4"));
			add(new User("user 5", "emil 5"));
			
		}};
		topics = new ArrayList<>();
		comments = new ArrayList<>();
		addNewTopic("emil 2", "tilte 1", "content 1");
		addNewTopic("emil 3", "tilte 2", "content 2");
		addNewTopic("emil 2", "tilte 3", "content 3");
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public ArrayList<Topic> getTopics() {
		return topics;
	}
	
	public void setTopics(ArrayList<Topic> topics) {
		this.topics = topics;
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}
	
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	public void addUser(User user) {
		this.getUsers().add(user);
	}
	
	public User getUserByEmail(String email) {
		return this.users.stream().filter(user ->
				user.getEmail().equals(email)).collect(Collectors.toList()).get(0);
		
	}
	
	public Topic getTopicById(int id) {
		return this.topics.stream().filter(topic ->
				topic.getTopicId() == id).collect(Collectors.toList()).get(0);
		
	}
	
	public List<Topic> topicsByUser(User user) {
		return this.topics.stream().filter(topic -> topic.getUser().getEmail().equals(user.getEmail()))
		                  .collect(Collectors.toList());
	}
	
	public List<Comment> commentsByUser(User user) {
		return this.comments.stream().filter(topic -> topic.getUser().getEmail().equals(user.getEmail()))
		                    .collect(Collectors.toList());
	}
	
	public void addNewTopic(String email, String title, String content) {
		
		Topic newTopic = new Topic(title, content);
		User user = this.getUserByEmail(email);
		newTopic.setUser(user);
		user.getTopics().add(newTopic);
		topics.add(newTopic);
	}
/*	public void addNewTopic(Topic topic){
		
		topic.setUser(topic.getUser());
		topic.getUser().getTopics().add(topic);
		topics.add(topic);
	}*/
	
	public void addNewComment(Topic topic, Comment comment, User user) {
		
		topic.getComments().add(comment);
		comment.setCommentOnTopic(topic);
		comment.setUser(user);
		System.out.println(user);
		user.getComments().add(comment);
		this.getComments().add(comment);
	}
	
	
}
