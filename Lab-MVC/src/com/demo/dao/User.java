package com.demo.dao;

import java.util.List;

public class User {

	private int userId;
	private String username;
	private String password;	
	private List<UserDetailBean> userDetail;

	/*public User(){
		setUserDetail(new UserDetailBean());
	}*/

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

	public List<UserDetailBean> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(List<UserDetailBean> userDetail) {
		this.userDetail = userDetail;
	}


	public void addUserDtl(UserDetailBean bean){

		bean.setUser(this);
		userDetail.add(bean);
	}



}
