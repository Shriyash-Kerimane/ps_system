package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Question1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("Processing request by"+Thread.currentThread().getName());
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.write("<h1>Welcome to servlet programing</h1>");		
	}
}
