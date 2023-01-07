package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImp;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 LoginService ls =new LoginServiceImp();
		 
		 String uname = request.getParameter("uname");
		 String password = request.getParameter("password");
		 
		 User u = ls.ValidateUser(uname,password);
		 if(u!=null) {
			 if(u.getRole().equals("admin")) {
				 System.out.println("hfjd");
				 RequestDispatcher rd= request.getRequestDispatcher("/product");
				 rd.forward(request, response);
				  
			 }
			 else {
				 out.println("Role is not matching");
				 RequestDispatcher rd= request.getRequestDispatcher("index.html");
				 rd.include(request, response);
 			 
			 }
		 }
		 else {
			 out.println("Invalid Credentials");
			 RequestDispatcher rd= request.getRequestDispatcher("index.html");
			 rd.include(request, response);
		 }
		 
		 
	}

}
