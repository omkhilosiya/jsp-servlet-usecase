package com.userproduct.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserProductDao {
	
static Connection con = null;
        

	
	
	
	public  static Connection getConnection() 
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
//			String dbConURL = "jdbc:mysql:/localhost:3306/lmaodead";
//			String user = "root";
//			String password ="1234567890";
//			
//			con = DriverManager.getConnection(dbConURL,user,password);
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","1234567890");


		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return con;
	}
	
	public static void closeConnection(Connection con)
	{
		try 
		{
			con.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
