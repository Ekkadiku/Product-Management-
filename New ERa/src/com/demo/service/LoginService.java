package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;

public interface LoginService {

	User ValidateUser(String uname, String password);

	List<Product> DisplayAll();

	
	boolean Addproduct(Product product);


	boolean RemoveProduct(int pid);

	boolean UpdateProduct(Product p);

}
