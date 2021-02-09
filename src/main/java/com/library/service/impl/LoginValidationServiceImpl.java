package com.library.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.library.client.TestMain;
import com.library.service.LoginValidationService;
import org.apache.log4j.Logger;

public class LoginValidationServiceImpl implements LoginValidationService
{
	static Logger log=Logger.getLogger(LoginValidationServiceImpl.class);
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(isr);
	
	public int fetchLogin(String userName,String password) throws IOException 
	{
	
		
		if(userName.equals("admin") && (password.equals("admin")))
		{
			log.info("Welcome "+userName+"!!!!!!!!");
			System.out.println("Welcome "+userName+"!!!!!!!!");
			return 1 ;
		}
		else if(userName.equals("student") && (password.equals("student")))
		{
			log.info("Welcome "+userName+"!!!!!!!!");
			System.out.println("Welcome "+userName+"!!!!!!!!");
			return 2;
			
		}
		else
		{
			return 3;
		}
	}

	@Override
	public void addUserStatus(boolean status)
	{
		if(status==true)
		{
			log.info("****User Added Successfully****");
			System.out.println("****User Added Successfully****");
		}
		else
		{
			log.info("****User Not Added Successfully****");
			System.out.println("****User Not Added Successfully****");
		}
	}

}
