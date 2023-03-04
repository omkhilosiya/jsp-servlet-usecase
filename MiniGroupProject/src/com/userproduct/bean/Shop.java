package com.userproduct.bean;

public class Shop {
	private String storename;
	private String address;
	private String city;
	private String userName;
	
	
	public Shop(String storename, String address, String city, String userName) {
		super();
		this.storename = storename;
		this.address = address;
		this.city = city;
		this.userName = userName;
	}
	
	
	
	
	
	




	public Shop(String storename, String address, String city) {
		super();
		this.storename = storename;
		this.address = address;
		this.city = city;
	}










	public Shop(String storename, String city) {
		super();
		this.storename = storename;
		this.city = city;
	}






	public Shop() {
		super();
	}






	public String getStorename() {
		return storename;
	}


	public void setStorename(String storename) {
		this.storename = storename;
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
	
	
	
	
	
	

}
