package com.userproduct.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import com.userproduct.bean.Customer;
import com.userproduct.bean.Shop;
import com.userproduct.bean.ShopCustomer;





public class UserCustomerService {
	
	private DataSource dataSource;

	public UserCustomerService(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	


	public List<ShopCustomer> getPreviousOrder(String userName) {
		// TODO Auto-generated method stub
		List<ShopCustomer> allUsers = new ArrayList<>();
		Connection conn = new UserProductDao().getConnection();
		
		
		
		try
		{
			String getUsersQuery = "Select * FROM userdetails where userName =? ";
			
			PreparedStatement pstmt = conn.prepareStatement(getUsersQuery);
        	pstmt.setString(1, userName);
        	ResultSet rs = pstmt.executeQuery();
        	
			
		
			
			while(rs.next())
			{
				ShopCustomer dbAccountSections = new ShopCustomer(rs.getString("productName"),rs.getString("productID"));
				allUsers.add(dbAccountSections);
			}
		
		}
		
		catch(SQLException e)
		{
			printSQLException(e);
			
		}
		return allUsers;
		
		
		
		
		
	}
	public List<ShopCustomer> getItems(String city) {
		// TODO Auto-generated method stub
		List<ShopCustomer> allUsers = new ArrayList<>();
		Connection conn = new UserProductDao().getConnection();
		
		
		
		try
		{
			String getUsersQuery = "Select * FROM shopdetails where city =? ";
			
			PreparedStatement pstmt = conn.prepareStatement(getUsersQuery);
        	pstmt.setString(1, city);
        	ResultSet rs = pstmt.executeQuery();
        	
			
		
			
			while(rs.next())
			{
				ShopCustomer dbAccountSections = new ShopCustomer(rs.getString("productName"),rs.getString("productId"),rs.getString("userName"));
				allUsers.add(dbAccountSections);
			}
			
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		return allUsers;
	
	}
	public void addorder(ShopCustomer user) 
	{
		
		try
		{
			System.out.println("i am in jdbc");
			String insertUserQuery = "insert into userdetails "
					                   + "(productName,productID,userName)"
					                   + "VALUES(?,?,?)";
			
			Connection conn = UserProductDao.getConnection();
		
			PreparedStatement ps = conn.prepareStatement(insertUserQuery);
			ps.setString(1, user.getProductName());
			ps.setString(2, user.getProductId());
			ps.setString(3, user.getUserName());
			
	
			
			ps.executeUpdate();
			System.out.println("jdbc was excuted ");
			
			
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	
	}
	private void printSQLException(SQLException ex) {
		for(Throwable e :ex) {
			e.printStackTrace(System.err);
			System.err.println("SQLSTATE: "+ ((SQLException)e).getSQLState());
			System.err.println("Error code: "+ ((SQLException)e).getErrorCode());
			System.err.println("Error code: "+ e.getMessage());
			Throwable t = ex.getCause();
			while(t!=null) {
				System.out.println("cause" +t);
				t =t.getCause();
			}

			

		}
		
	}



	public void addUser(Customer newUser) {
		
		
		try
		{
			System.out.println("i am in jdbc");
			String insertUserQuery = "insert into user "
					                   + "(firstName,lastName,dob,city,age,userName)"
					                   + "VALUES(?,?,?,?,?,?)";
			
			Connection conn = UserProductDao.getConnection();
		
			PreparedStatement ps = conn.prepareStatement(insertUserQuery);
			ps.setString(1, newUser.getFristname());
			ps.setString(2, newUser.getLastname());
			ps.setString(3, newUser.getDateofbirth());
			ps.setString(4, newUser.getCity());

			ps.setInt(5, newUser.getAge());

			ps.setString(6, newUser.getUserName());

			
			
			
	
			
			ps.executeUpdate();
			System.out.println("jdbc was excuted ");
			
			
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		
		
	}



	public void addShop(Shop user) {
		try
		{
			System.out.println("i am in jdbc");
			String insertUserQuery = "insert into shop "
					                   + "(storeName,address,city,userName)"
					                   + "VALUES(?,?,?,?)";
			
			Connection conn = UserProductDao.getConnection();
		
			PreparedStatement ps = conn.prepareStatement(insertUserQuery);
			ps.setString(1, user.getStorename() );
			ps.setString(2, user.getAddress());
			ps.setString(3, user.getCity());
			ps.setString(4, user.getUserName());		
			ps.executeUpdate();
			System.out.println("jdbc was excuted ");
			
			
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		
		
		
		
	}
	
     public boolean validUserid(Customer haha) {
		
		boolean isthere= false;
		try {
			Connection conn = UserProductDao.getConnection();
			String insertSQL = "select * from user where firstName = ? and dob =?";
        
        	PreparedStatement pstmt = conn.prepareStatement(insertSQL);
        	pstmt.setString(1, haha.getFristname());
        	pstmt.setString(2,haha.getDateofbirth());
        	

			 ResultSet rs = pstmt.executeQuery();
			 
			 isthere =rs.next();
			 

		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return isthere;
		
		
	}



	public boolean validShopid(Shop haha) {
		boolean isthere= false;
		try {
			Connection conn = UserProductDao.getConnection();
			String insertSQL = "select * from shop where storeName = ? and city =?";
        
        	PreparedStatement pstmt = conn.prepareStatement(insertSQL);
        	pstmt.setString(1, haha.getStorename());
        	pstmt.setString(2,haha.getCity());
        	

			 ResultSet rs = pstmt.executeQuery();
			 
			 isthere =rs.next();
			 

		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return isthere;
		
		
		
	}



	public List<ShopCustomer> getshopproducts(String username) {
		List<ShopCustomer> allUsers = new ArrayList<>();
		Connection conn = new UserProductDao().getConnection();
		
		
		
		try
		{
			String getUsersQuery = "Select * FROM shopdetails where userName =? ";
			
			PreparedStatement pstmt = conn.prepareStatement(getUsersQuery);
        	pstmt.setString(1, username);
        	ResultSet rs = pstmt.executeQuery();
        	
			
		
			
			while(rs.next())
			{
				ShopCustomer dbAccountSections = new ShopCustomer(rs.getString("productName"),rs.getString("productId"));
				allUsers.add(dbAccountSections);
			}
			
		
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		return allUsers;
		

	}



	public void additems(ShopCustomer user) {
		try
		{
			System.out.println("i am in jdbc");
			String insertUserQuery = "insert into shopdetails "
					                   + "(productName,productId,city,userName)"
					                   + "VALUES(?,?,?,?)";
			
			Connection conn = UserProductDao.getConnection();
		
			PreparedStatement ps = conn.prepareStatement(insertUserQuery);
			ps.setString(1, user.getProductName());
			ps.setString(2, user.getProductId());
			ps.setString(3, user.getCity());
			ps.setString(4, user.getUserName());
			
	
			
			ps.executeUpdate();
			System.out.println("jdbc was excuted ");
			
			
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
	}
	
	  public boolean validorder(String productID) {
			
			boolean isthere= false;
			try {
				Connection conn = UserProductDao.getConnection();
				String insertSQL = "select * from shopdetails where productId = ?";
	        
	        	PreparedStatement pstmt = conn.prepareStatement(insertSQL);
	        	pstmt.setString(1, productID);
	        	

				 ResultSet rs = pstmt.executeQuery();
				 
				 isthere =rs.next();
				 

			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
			return isthere;
			
			
		}
	  




	
	
	
	

}



