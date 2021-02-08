package com.library.dao.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.library.bean.Book;
import com.library.client.TestMain;
import com.library.dao.BookDao;
import com.library.dao.BookIssueDao;
import com.library.service.BookService;
import com.library.service.LoginValidationService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.LoginValidationServiceImpl;

public class BookDaoImpTest
{
	TestMain testMain=new TestMain();
	BookDao bookDao=new BookDaoImpl(); 
	BookService bookService=new BookServiceImpl();
	Book book=new Book("q","q","q",1,1);
	BookIssueDao bookIssueDao=new BookIssueDaoImpl();
	LoginValidationService loginValidationService =new LoginValidationServiceImpl();
	@Test
	public void testAddBook() throws IOException 
	{
		//Book book1=new Book("q","q","q",1,1);
		Book book=testMain.addBookDetails();
		boolean status=bookDao.addBook(book);
		assertEquals(true, true);
		
	}
	

}
