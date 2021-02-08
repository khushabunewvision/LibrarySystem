package com.library.bean;

import java.io.Serializable;

public class User implements Serializable
{
	private String userName;
	private String password;
	private String userType;
	private int userId;
	
	public User()
	{
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, String userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
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

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userType=" + userType + ", userId=" + userId
				+ "]";
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}
