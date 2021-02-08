package com.library.bean;

public class Student extends User {

	
	private Address address;
	private String studentName;
	private User user;
	
	public Student() 
	{
		super();
	}

	public Student(String userName,String password,String userType,String Role,String studentName, String temporary, String permanent)
	{
		super(userName,password,userType);
		this.studentName=studentName;
		address = new Address(temporary, permanent);
	}
	

	public Address getAddress() {
		return address;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Student [address=" + address + ", studentName=" + studentName + ", user=" + user + "]";
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}
