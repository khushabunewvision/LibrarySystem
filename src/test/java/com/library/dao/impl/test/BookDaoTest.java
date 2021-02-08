package com.library.dao.impl.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.library.bean.Book;
import com.library.client.TestMain;
import com.library.dao.BookDao;
import com.library.dao.BookIssueDao;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookIssueDaoImpl;
import com.library.service.BookService;
import com.library.service.LoginValidationService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.LoginValidationServiceImpl;

public class BookDaoTest
{
	TestMain testMain=new TestMain();
	BookDao bookDao=new BookDaoImpl(); 
	BookService bookService=new BookServiceImpl();
	Book book=new Book("q","q","q",1,1);
	BookIssueDao bookIssueDao=new BookIssueDaoImpl();
	LoginValidationService loginValidationService =new LoginValidationServiceImpl();
	
	@Test
	public void testForAddNewBook() throws IOException 
	{
		Book book=testMain.addBookDetails();
		boolean status=bookDao.addBook(book);
		bookService.addBookStatus(status);
		assertEquals("q",book.getBookName());
		assertEquals("q",book.getAuthorName());
		assertEquals("q",book.getBookSubject());
		assertEquals(1,book.getPageNo());
		assertEquals(1,book.getPrice());
	}
	@Test
	public void testForBookIssue() throws IOException
	{
		Book book=testMain.addBookDetails();
		boolean status=bookDao.addBook(book);
		bookService.addBookStatus(status);
		bookIssueDao.requestIssueBook();
		assertEquals(false,book.isAvailable());
		
	}

}
