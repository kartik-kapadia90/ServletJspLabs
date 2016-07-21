package com.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//resp.getWriter().write(LocalDateTime.now().toString());
		req.setAttribute("message", "Welcome, today is Wednesday");
		req.getRequestDispatcher("response.jsp").forward(req, resp);
	}

}
