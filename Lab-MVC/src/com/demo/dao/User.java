package com.demo.dao;

public class User {

	private int userId;
	private String username;
	private String password;	
	private UserDetailBean userDetail;
	
	public User(){
		setUserDetail(new UserDetailBean());
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public UserDetailBean getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetailBean userDetail) {
		this.userDetail = userDetail;
		userDetail.setUser(this);
	}




}
