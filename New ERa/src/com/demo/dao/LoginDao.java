package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;

public interface LoginDao {

	User Validuser(String uname, String password);

	List<Product> Display();

	

	boolean Addprod(Product p);

	boolean Remove(int pid);

	boolean Update(Product p);

}
