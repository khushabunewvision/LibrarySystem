package com.library.service;

import java.io.IOException;

public interface LoginValidationService
{
	public int fetchLogin(String userName,String password) throws IOException;
	public void addUserStatus(boolean status);
	
}
