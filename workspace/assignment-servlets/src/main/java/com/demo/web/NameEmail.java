package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NameEmail extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		if(name=="" || email=="")
        {
            out.print("<h1>Fields cannot be empty</h1>");
            out.print("<a href='loginPage.html'>Go Back to Login Page</a>");
        }
        else {
        
        out.print("<h1>The Name = "+name+" Email= " + email + "</h1>");
        out.print("<a href='loginPage.html'>Go Back to main Page</a>");
        }
	}
}
