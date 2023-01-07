package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImp;


@WebServlet("/product")
public class DisplayProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in product");
		response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         LoginService ls = new LoginServiceImp();
         List<Product>plist=ls.DisplayAll();
         out.println("<body style='background-image: url(images/display1.jpg);background-size:cover;'><div align='right'><a href='Landing.html'><h3>Log Out</h3></a></div>");
         out.println("<div align='center' style='color: maroon;'><h1>List Of Product</h1><br>");
         out.println("<a href ='AddProduct.html'>AddProduct</a>");
         out.println("<table border='4'><tr><th>Id</th><th>Name</th><th>qty</th><th>Price</th><th>Operations</th></tr>");
         for(Product p :plist) {
        	 out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td>");
        	 out.println("<td><a href='deleteproduct?pid="+p.getPid()+"'>delete</a> / <a href='Edit.html?pid="+p.getPid()+"'>edit</a></td></tr>");
         }
         out.println("</table></div></body>");

         
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
