package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	private static final String url="jdbc:mysql://localhost:3306/jdbcproject";
	private static final String username="root";
	private static final String password="nagesh123@";
	
 public static Connection jdbcConnection(){
	 
	  Connection con=null;
	  try {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  con= DriverManager.getConnection(url,username,password);
	  }catch(Exception e) {
		  e.printStackTrace();
		  }
	  return con;
  }
}
