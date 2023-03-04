package com.userproduct.bean;

public class ShopCustomer {
	 private String storeName;
	 private String  address;
	 private String city;
	 private String userName;
	 private String firstName;
	 private String lastName;
	 private String dob; 
	 private int age;
	 private String productId;
	 private String datePlaced;
	 private String productName;
	 
	 
	 


	public ShopCustomer( String productName, String productId,String city, String userName) {
		super();
		this.city = city;
		this.userName = userName;
		this.productId = productId;
		this.productName = productName;
	}











	public ShopCustomer(String productName, String productId,String userName) {
		super();
		this.userName = userName;
		this.productId = productId;
		this.productName = productName;
	}











	public ShopCustomer(String productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}











	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getDob() {
		return dob;
	}




	public void setDob(String dob) {
		this.dob = dob;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public String getProductId() {
		return productId;
	}




	public void setProductId(String productId) {
		this.productId = productId;
	}




	public String getDatePlaced() {
		return datePlaced;
	}




	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}









	public String getProductName() {
		return productName;
	}









	public void setProductName(String productName) {
		this.productName = productName;
	} 

}
