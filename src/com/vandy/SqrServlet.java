package com.vandy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SqrServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		Cookie cookies[] = req.getCookies();
		
		/*
		 * HttpSession session = req.getSession();
		 * 
		 * // int k = Integer.parseInt(req.getParameter("k")); 
		 * int k = (int)session.getAttribute("k"); 
		 */
		
		int k = 0;
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("k")) {
				k = Integer.parseInt(cookie.getValue());
			}
		}
		
		 k *= k;

		out.println("Result is " + k);

	}
}
