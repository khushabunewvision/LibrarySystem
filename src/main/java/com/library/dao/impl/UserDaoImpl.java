package com.library.dao.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.library.bean.Book;
import com.library.bean.User;
import com.library.dao.UserDao;

public class UserDaoImpl implements UserDao
{
	static Logger log=Logger.getLogger(UserDaoImpl.class);
	public static ArrayList<User> userList=new ArrayList<>();
	boolean status=false;

	@Override
	public boolean addUser(User user)
	{
		if(user.getUserId()!=0)
		{
			userList.add(user);
			status=true;	
		}
		else
		{
			status=false;
		}
		
		return status;
		
	}

	@Override
	public void getAllUser() 
	{
		if(userList.isEmpty())
		{
			System.out.println("****Nothing To Display****");
		}
		else
		{
			System.out.println("*******Displaying All Books******");
			for(User u:userList)
			{
				System.out.println(u.toString());
			}
		}
	}

}
