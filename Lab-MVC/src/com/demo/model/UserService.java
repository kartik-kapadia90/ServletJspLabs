package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.demo.dao.UserDetailBean;

public class UserService {

	
	
	public List<UserDetailBean> getUsersList(){
		
		List<UserDetailBean> list = new ArrayList<UserDetailBean>();
		UserDetailBean bean = new UserDetailBean();
		bean.setDate("07/21/2016");
		bean.setDescription("Hello");
		bean.setName("John");
		bean.setPrice(100);
		bean.setQuantity(10);
		
		list.add(bean);
		
		bean = new UserDetailBean();
		bean.setDate("07/22/2016");
		bean.setDescription("World");
		bean.setName("Doe");
		bean.setPrice(1000);
		bean.setQuantity(5);
		list.add(bean);
		return list;
	}
}
