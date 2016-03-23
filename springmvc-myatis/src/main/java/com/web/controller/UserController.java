package com.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
@RestController
public class UserController {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@JsonView(User.WithPasswordView.class)
	public User getUser() {
		return new User("eric", "7!jd#h23");
	}
}

class User {
	public interface WithoutView {
	};

	public interface WithPasswordView extends WithoutView {
	};
	
	public interface WithUserNameView extends WithoutView {
	};

	private String username;
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@JsonView(WithUserNameView.class)
	public String getUsername() {
		return this.username;
	}

	@JsonView(WithPasswordView.class)
	public String getPassword() {
		return this.password;
	}
}