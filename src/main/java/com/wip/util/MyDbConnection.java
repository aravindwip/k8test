package com.wip.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbConnection {	
	
	private MyDbConnection() {
		
	}
	
	private static Connection con;
	public static Connection getMyConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Aravind@123");
			System.out.println("Connection Established Successfully : " +con);
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		getMyConnection();

	}

}
