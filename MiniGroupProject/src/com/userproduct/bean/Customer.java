package com.userproduct.bean;

public class Customer {
	private String fristname;
	private String lastname;
	private String dateofbirth;
	private String city;
	private int age;
	private String userName;
	
	public Customer(String fristname, String lastname, String dateofbirth, String city, int age, String userName) {
		super();
		this.fristname = fristname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.city = city;
		this.age = age;
		this.userName = userName;
	}
	
	
	
	
	






	public Customer(String fristname, String dateofbirth, String city) {
		super();
		this.fristname = fristname;
		this.dateofbirth = dateofbirth;
		this.city = city;
	}











	public Customer() {
		super();
	}
	
	











	public Customer(String fristname, String dateofbirth) {
		super();
		this.fristname = fristname;
		this.dateofbirth = dateofbirth;
	}











	public String getFristname() {
		return fristname;
	}

	public void setFristname(String fristname) {
		this.fristname = fristname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	

}
