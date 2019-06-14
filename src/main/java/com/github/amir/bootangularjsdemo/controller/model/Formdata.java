package com.github.amir.bootangularjsdemo.controller.model;

import javax.validation.constraints.Size;

public class Formdata {
	
	@Size(min = 10, max = 200, message="{username.errors.message}")
	private String username;
	@Size(min = 10, max = 200, message="{password.errors.message}")
	private String password;
	
	private String repeatpass;

	public String getRepeatpass() {
		return repeatpass;
	}

	public void setRepeatpass(String repeatpass) {
		this.repeatpass = repeatpass;
	}

	public Formdata() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
