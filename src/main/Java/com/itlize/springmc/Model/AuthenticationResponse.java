package com.itlize.springmc.Model;

import java.io.Serializable;

import com.itlize.springmc.bean.User;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private int userID;
    private String username;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJwttoken() {
		return jwttoken;
	}
	public AuthenticationResponse(String jwttoken, User user) {
		super();
		this.jwttoken = jwttoken;
		
		this.userID = user.getId();
		this.username = user.getPassword();
	}
	
    
	
	
}