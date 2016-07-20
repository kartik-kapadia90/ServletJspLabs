package com.demo.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		String username = (String) req.getParameter("username");
		String password = (String) req.getParameter("password");
		
		if(username.length()>=6 && password.length()>=8){
			req.setAttribute("username", username);
			req.setAttribute("msg", "success");
			Cookie myCookie =  new Cookie("user-id", username);
			resp.addCookie(myCookie);
		}
		else{
			req.setAttribute("msg", "failure");
		}
		
		req.getRequestDispatcher("response.jsp").forward(req, resp);
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		doGet(req,resp);
	}
}
