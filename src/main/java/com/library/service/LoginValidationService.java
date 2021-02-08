package com.library.service;

import java.io.IOException;

public interface LoginValidationService
{
	public int credententials() throws IOException;
	public void addUserStatus(boolean status);
	
}
