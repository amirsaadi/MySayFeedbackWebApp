package com.amir.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Amir on 2017-02-17.
 * MySayFeedbackWebApp
 */

@Entity
@Table(name="WEB_USER")
public class MySayUser implements UserDetails {
	
	@Id
	@GeneratedValue
	private Long userId ;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL")
	private String Email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Transient
	private String passwordConfirm;
	@Column(name = "USER_ROLE")
	private String role="ROLE_USER";
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Collection<Topic> topics= new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Collection<Comment> comments= new ArrayList<>();
	
	public MySayUser() {
	}
	
	public MySayUser(String name, String email, String password) {
		this.name = name;
		Email = email;
		this.password = password;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public String getPassword() {
		return null;
	}
	
	@Override
	public String getUsername() {
		return null;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	
	@Override
	public boolean isEnabled() {
		return false;
	}
}
