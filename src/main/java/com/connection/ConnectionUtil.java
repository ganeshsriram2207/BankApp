package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection()
	{
	
	String driverClass = "com.mysql.jdbc.Driver";
	
	String url = "jdbc:mysql://localhost:3306/Bank";
	
	String userName = "root";
	String userPassword = "ganeshsriram22";
	Connection conn = null;
	try {
		Class.forName(driverClass);
		conn = DriverManager.getConnection(url,userName,userPassword);
		System.out.println(conn);
		} 
	catch (ClassNotFoundException e) 
	{
		
		e.printStackTrace();
	}
	
	catch (SQLException e)
	{
		e.printStackTrace();
	}
	
	return conn;
	}
}