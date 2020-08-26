package com.vandy;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int k = i + j;

		// Two ways to call another servlet Req Dispatcher or redirect

		// dispatcher

		/*
		 * req.setAttribute("k", k);
		 * 
		 * RequestDispatcher rd = req.getRequestDispatcher("sqr"); rd.forward(req, res);
		 */

		// redirect

		/*
		 * res.sendRedirect("sqr?k=" + k); //Url Rewriting
		 */		
		
		//Session management
		
		/*
		 * HttpSession session = req.getSession(); session.setAttribute("k", k);
		 * 
		 * res.sendRedirect("sqr");
		 */
		
		//Cookies
		
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);
		
		res.sendRedirect("sqr");
		
	}
}
