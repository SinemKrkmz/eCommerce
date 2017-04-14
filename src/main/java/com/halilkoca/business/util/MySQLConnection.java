package com.halilkoca.business.util;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySQLConnection {
	
	public static final String URL = "jdbc:mysql://localhost:3306/eCommerce?useUnicode=true&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	
	public static Connection getConnection()
	{
		try {
			
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASSWORD);




		} catch (SQLException ex) {
			throw new RuntimeException("Error connection to database", ex);
		}
		
	}
	
	public static void main(String[] args) throws SQLException{
		Connection connection = MySQLConnection.getConnection();
		
		System.out.println(connection);
	}
	

}
