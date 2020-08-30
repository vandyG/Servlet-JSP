package com.vandy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/sqr", initParams = @WebInitParam(name = "name", value = "Vandit*Vandit"))
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
		
		ServletContext ctx = getServletContext();
		String ctxName = ctx.getInitParameter("name");
		
		out.println(ctxName);
		
		ServletConfig conf = getServletConfig();
		String confName = conf.getInitParameter("name");
		
		out.println(confName);

	}
}
