package com.mega.mvc04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id = null;
	String pw = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("id");
		pw = config.getInitParameter("pw");
		System.out.println(id);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("welcome!! get!!");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>id: " + id + "</h1>");
		out.println("<h1>pw: " + pw + "</h1>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("welcome!! post!!");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>id: " + id + "</h1>");
		out.println("<h1>pw: " + pw + "</h1>");
		out.close();
	}

}
