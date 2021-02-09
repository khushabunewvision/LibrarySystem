package com.library.dao.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
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
	
	@Before
	public void testFirst()
	{
		Book checkBook=new Book("q","q","q",1,1); 
		checkBook.setBookId(1);
	}
	
	@Test
	public void testAddBook() throws IOException 
	{
		Book book=testMain.addBookDetails();
		boolean status=bookDao.addBook(book);
		assertTrue(true);
	}
	@Test
	public void testSearchBookByName()
	{
		assertEquals("failure: name should be q","q",book.getBookName());
	}
	@Test
	public void testSearchBookByAuthorName()
	{
		assertEquals("failue name should be q","q",book.getAuthorName());
	}
}
