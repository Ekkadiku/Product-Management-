package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
      private static Connection con = null;
      
      public  static Connection GetMyConnection() {
    	  if(con==null) {
    		  try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url = "jdbc:mysql://192.168.10.109:3306/dac21";
				String uname="dac21";
				String password="welcome";
				con = DriverManager.getConnection(url, uname, password);
				
				return con;
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		  
    	  }
    	return null;  
      }
      
      public static void CloseMyConnection() {
    	  try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
      }
}
