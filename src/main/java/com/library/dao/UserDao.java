package com.library.dao;

import com.library.bean.Book;
import com.library.bean.User;

public interface UserDao 
{
	public boolean addUser(User user);
	public void getAllUser();
	
}
