package com.amir.controller;


import com.amir.model.Comment;
import com.amir.model.Topic;
import com.amir.model.User;
import com.amir.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final DataService dataService;
	private User webUser;
	
	private User getWebUser() {
		return webUser;
	}
	
	private void setWebUser(User webUser) {
		this.webUser = webUser;
	}
	
	@Autowired
	public HomeController(DataService dataService) {
		this.dataService = dataService;
	}
	
	@RequestMapping("/")
	public String home() {
		return "login";
	}
	
	
	/*Method saves the logged in user*/
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String logIn(Model model, @ModelAttribute User user) {
		User newUser = new User(user.getName(),user.getEmail());
		dataService.addUser(newUser);
		this.setWebUser(newUser);
		model.addAttribute("user",user);
		model.addAttribute("topics", this.dataService.getTopics());
		model.addAttribute("comments",this.dataService.getComments());
		return "topic";
	}
	
	/*Method adds a comment to the corresponding comment
	* In Topic.jsp there are two forms, a params is passed the controller class and this method will invoke
	**/
	@RequestMapping(value = "/topic", method = RequestMethod.POST, params = "submitComment")
	public String addNewComment(@ModelAttribute Comment comment,Model model) {
		
		/* the Topic id that passed from a hidden input and will be used to get the topic */
		int id =comment.getCommentId();
		Topic topic=dataService.getTopicById(id);
		Comment newComment = new Comment(comment.getMess());
		webUser=this.getAnonymousUser();
		dataService.addNewComment(topic,newComment,webUser);
		model.addAttribute("user",webUser);
		model.addAttribute("topics", this.dataService.getTopics());
		model.addAttribute("comments",this.dataService.getComments());
		return "redirect:/topic";
	}
	
	@RequestMapping(value = "/topic", method = RequestMethod.GET)
	public String showTopics(Model model) {
		webUser=this.getAnonymousUser();
		model.addAttribute("user",webUser);
		model.addAttribute("topics", this.dataService.getTopics());
		model.addAttribute("comments",this.dataService.getComments());
		return "topic";
	}
	
	/*Method adds new topic */
	@RequestMapping(value = "/topic", method = RequestMethod.POST)
	public String addNewTopic(@ModelAttribute Topic topic, Model model) {
		webUser=this.getAnonymousUser();
		topic.setUser(dataService.getUserByEmail(webUser.getEmail()));
		if (!topic.getTitle().trim().equals("") && !topic.getContent().trim().equals("")) {
			dataService.addNewTopic(webUser.getEmail(), topic.getTitle(), topic.getContent());
		}
		model.addAttribute("user",webUser);
		model.addAttribute("topics", this.dataService.getTopics());
		model.addAttribute("comments",this.dataService.getComments());
		return "redirect:/topic";
	}
	
	/* since no validation strategy is used in login form ,
	this method creates an ananymous user if user enters tainted data */
	private User getAnonymousUser(){
		if (getWebUser()==null||getWebUser().getEmail().trim().equals("")||
				getWebUser().getName().trim().equals("")){
			dataService.addUser(new User("Anonymous","sample"));
			return new User("Anonymous","sample");
		}
		return webUser;
	}
}
