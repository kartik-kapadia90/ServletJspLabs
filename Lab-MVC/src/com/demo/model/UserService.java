package com.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.dao.User;
import com.demo.dao.UserDetailBean;
import com.demo.util.HibernateUtilities;

public class UserService {

	
	public int getUserId(String username, String password){

		int id = 0;
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "FROM User U WHERE U.username='"+username+"' AND U.password='"+password+"'";
		Query query = session.createQuery(hql);
		List<User> results = query.list();		
		if(results.size()>0)
			id = results.get(0).getUserId();
		session.getTransaction().commit();
		
		if(id>0)
			return id;
		else
			return 0;
		

	}
	
	
	public List<UserDetailBean> getUsersList(){
		
		/*
		 * Hard-coded values for previous lab
		 * List<UserDetailBean> list = new ArrayList<UserDetailBean>();
		UserDetailBean bean = new UserDetailBean();
		bean.setDate(new Date());
		bean.setDescription("Hello");
		bean.setName("John");
		bean.setPrice(100);
		bean.setQuantity(10);
		
		list.add(bean);
		
		bean = new UserDetailBean();
		bean.setDate(new Date());
		bean.setDescription("World");
		bean.setName("Doe");
		bean.setPrice(1000);
		bean.setQuantity(5);
		list.add(bean);*/
		
		
		//Using hibernate and mysql to get the data
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		String hql = "FROM UserDetailBean";
		Query query = session.createQuery(hql);
		List<UserDetailBean> list = query.list();	
		session.getTransaction().commit();
		return list;
	}
	
	
	public List<UserDetailBean> getUserDetails(int userId){
		
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		User loadedUser = (User)session.get(User.class,userId);
		session.getTransaction().commit();
		return loadedUser.getUserDetail();
	}
	
	
	public void addUserDetail(UserDetailBean bean, int userId){
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		User loadedUser = (User)session.get(User.class,userId);
		bean.setUser(loadedUser);
		loadedUser.addUserDtl(bean);
		session.save(bean);
		session.getTransaction().commit();
		
		
	}
}
