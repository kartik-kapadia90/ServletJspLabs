package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.UserDetailBean;
import com.demo.model.UserService;

public class ActionServlet extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String action = req.getParameter("action");
		if("login".equalsIgnoreCase(action)){

			String username = (String) req.getParameter("username");
			String password = (String) req.getParameter("password");
			UserService service = new UserService();
			int userId=service.getUserId(username, password);
			if(userId>0){
				req.setAttribute("username", username);
				req.setAttribute("msg", "success");
				Cookie myCookie =  new Cookie("user-id", Integer.toString(userId));
				List<UserDetailBean> users;
				if(username.contains("admin")){
					users = service.getUsersList();
				}
				else{					
					UserDetailBean userDetail = service.getUserDetails(userId);
					users = new ArrayList<UserDetailBean>();
					users.add(userDetail);
				}
				req.setAttribute("data", users);
				//req.setAttribute("data", userDetail);
				
				//For day-9
				
				//req.setAttribute("data", users);
				resp.addCookie(myCookie);
				req.getRequestDispatcher("response.jsp").forward(req, resp);
			}	
			else{
				req.setAttribute("msg", "failure");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}

			

		}
		else if("logout".equalsIgnoreCase(action)){
			doLogout(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doGet(req,resp);
	}

	public void doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setValue(null);
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
