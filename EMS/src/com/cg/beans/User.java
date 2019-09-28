package com.cg.beans;

public class User {
	private String userId;
	private String userName;
	private String password;
	private String userType;
	
	public User() {
		
	}
	public User(String userId, String userName, String password, String userType) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
