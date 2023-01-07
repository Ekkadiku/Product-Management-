package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImp;

public class LoginServiceImp implements LoginService {
	
	private LoginDao ldao;

	public LoginServiceImp() {
       ldao = new LoginDaoImp();
	}

	@Override
	public User ValidateUser(String uname, String password) {
		return ldao.Validuser(uname,password);
	}

	@Override
	public List<Product> DisplayAll() {
		return ldao.Display();
	}

	@Override
	public boolean Addproduct(Product p) {
		return ldao.Addprod(p);
	}

	@Override
	public boolean RemoveProduct(int pid) {
		return ldao.Remove(pid);
	}

	@Override
	public boolean UpdateProduct(Product p) {
		return ldao.Update(p);
	}
	
	

}
