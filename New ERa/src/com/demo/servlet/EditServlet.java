package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImp;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    int pid = Integer.parseInt(request.getParameter("pid"));
	    String pname = request.getParameter("pname");
	    int qty = Integer.parseInt(request.getParameter("qty"));
	    double price = Double.parseDouble(request.getParameter("price"));
	    
	    LoginService ls=new LoginServiceImp();
	    boolean status = ls.UpdateProduct(new Product(pid,pname,qty,price));
	    if(status) {
	    	RequestDispatcher rd = request.getRequestDispatcher("product");
	    	rd.forward(request, response);
	    }
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
