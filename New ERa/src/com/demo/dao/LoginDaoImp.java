package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.mysql.cj.protocol.Resultset;

public class LoginDaoImp implements LoginDao {
	
	private static Connection con;
	
	private static PreparedStatement plogin,psel,pins,pdel,pupd;
	
	static {
		
		try {
			con = DBUtil.GetMyConnection();
			plogin=con.prepareStatement("select * from user where uname =? and password=? ");
			psel=con.prepareStatement("select * from product");
			pins=con.prepareStatement("insert into product values(?,?,?,?)");
			pdel=con.prepareStatement("delete from product where pid = ?");
			pupd=con.prepareStatement("update product set pname=?,qty=?,price=? where pid=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User Validuser(String uname, String password) {
		try {
			plogin.setString(1, uname);
			plogin.setString(2, password);
			ResultSet rs=plogin.executeQuery();
			if(rs.next()) {
				User u = new User(rs.getString(1),rs.getString(2),rs.getString(3));
				return u ;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return null;
	}

	@Override
	public List<Product> Display() {
		List<Product>plist = new ArrayList<>();
		try {
			ResultSet rs=psel.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
			}
			if(plist.size()>0)
				return plist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean Addprod(Product p) {
		 List<Product>plist=new ArrayList<>();
		try {
			pins.setInt(1, p.getPid());
			pins.setString(2, p.getPname());
			pins.setInt(3, p.getQty());
			pins.setDouble(4, p.getPrice());
			
			pins.executeUpdate();
	       
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 plist.add(p);	
		
		return true;
	}

	@Override
	public boolean Remove(int pid) {
		 try {
			pdel.setInt(1, pid);
			pdel.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean Update(Product p) {
		try {
			
			pupd.setString(1, p.getPname());
			pupd.setInt(2, p.getQty());
			pupd.setDouble(3, p.getPrice());
			pupd.setInt(4, p.getPid());
			pupd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	
	

}
