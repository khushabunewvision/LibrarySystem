package com.library.bean;

import java.io.Serializable;

public class Address implements Serializable
{

	private String temporary;
	private String permanent;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String temporary, String permanent) 
	{
		this.temporary = temporary;
		this.permanent = permanent;
	}

	public String getTemporary() 
	{
		return temporary;
	}

	public void setTemporary(String temporary)
	{
		this.temporary = temporary;
	}

	public String getPermanent() 
	{
		return permanent;
	}

	public void setPermanent(String permanent)
	{
		this.permanent = permanent;
	}

	@Override
	public String toString() 
	{
		return "Address [temporary=" + temporary + ", permanent=" + permanent + "]";
	}
}
