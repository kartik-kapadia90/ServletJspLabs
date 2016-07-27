package com.demo.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.demo.dao.User;
import com.demo.util.HibernateUtilities;

public class LoginService {


	public boolean isUserAuthenticated(String username, String password){

		boolean flag = false;
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "FROM User U WHERE U.username='"+username+"' AND U.password='"+password+"'";
		Query query = session.createQuery(hql);
		List<User> results = query.list();
		/*for(User user: results){

		}*/
		if(results.size()>0)
			flag = true;
		session.getTransaction().commit();


		return flag;

	}

	public User getUserData(String username){

		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		String hql = "FROM User U WHERE U.username='"+username+"'";
		Query query = session.createQuery(hql);
		List<User> results = query.list();
		User user= results.get(0);

		session.getTransaction().commit();
		return user;

	}

}
