package com.library.bean;

import java.io.Serializable;

public class Librarian extends User implements Serializable 
{ 
	private String librarianName;
	private User user;
	
	@Override
	public String toString() {
		return "Librarian [librarianName=" + librarianName + ", user=" + user + "]";
	}



	public Librarian() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Librarian(String userName, String password,String role,String librarianName)
	{
		super(userName,password,role);
		this.librarianName=librarianName;
		
	}



	public String getLibrarianName() {
		return librarianName;
	}



	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}



	
	}
