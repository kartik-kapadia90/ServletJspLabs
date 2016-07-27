package com.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dao.User;
import com.demo.model.LoginService;

public class LoginServlet extends HttpServlet{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

		String action = req.getParameter("action");
		if("logout".equalsIgnoreCase(action)){
			doLogout(req, resp);
		}
		else if("login".equalsIgnoreCase(action))
		{
			String username = (String) req.getParameter("username");
			String password = (String) req.getParameter("password");

			//Hardcoded validation
			/*if(username.length()>=6 && password.length()>=8){
			req.setAttribute("username", username);
			req.setAttribute("msg", "success");
			Cookie myCookie =  new Cookie("user-id", username);
			resp.addCookie(myCookie);
		}
		else{
			req.setAttribute("msg", "failure");
		}*/



			//User login authentication using database information
			LoginService service = new LoginService();

			if(service.isUserAuthenticated(username, password)){
				User user = service.getUserData(username);
				req.setAttribute("username", username);
				req.setAttribute("msg", "success");
				Cookie myCookie =  new Cookie("user-id", Integer.toString(user.getUserId()));


				resp.addCookie(myCookie);
			}
			else{
				req.setAttribute("msg", "failure");
			}
			req.getRequestDispatcher("response.jsp").forward(req, resp);
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
