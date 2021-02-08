package com.library.service.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.library.bean.Book;
import com.library.dao.impl.BookDaoImpl;
import com.library.service.BookService;

public class BookServiceImpl implements BookService
{
	static Logger log=Logger.getLogger(BookServiceImpl.class);
	public void addBookStatus(boolean status)
	{
		if(status==true)
		{
			log.info("****Book Added Successfully****");
			System.out.println("****Book Added Successfully****");
		}
		else
		{
			log.info("****Book Not Added Successfully****");
			System.out.println("****Book Not Added Successfully****");
		}
	}

	@Override
	public void searchStatus(ArrayList<Book> book)
	{
		if(book.isEmpty())
		{
			System.out.println("****Book Not found****");
		}
		else
		{
			for(Book b:book)
			{
				System.out.println(b.toString());
			}		
		}
	}
	
	public void issueBook(Book b,boolean status)
	{
		if(status==true)
		{
		 	BookDaoImpl.bookIssueList.add(b);
	        b.setAvailable(false);
	        System.out.println("!!!!!!!!!!!!!!Book Issue Successfully!!!!!!!");
	        log.info("Book Issued Successfully");
		}
		else
		{
			System.out.println("Book Not Issued");
			log.info("Book Not Issued");
		}
	 }
	
	public void confirmReturnBook(Book book,boolean status)
    {
		if(status==true)
		{
	    	BookDaoImpl.bookIssueList.remove(book);
	        book.setAvailable(true);
	        System.out.println("!!!!!!!!!!Book Returned Successfully!!!!!!!!!!!!");
	        log.info("!!!!!Book Returned Successfully!!!!!!");
		}
		else
		{
			System.out.println("Book Not Returned");
		}
    }

	@Override
	public void referenceBook(Book b, boolean status) 
	{
		if(status==true)
		{
		 	BookDaoImpl.bookReferenceList.add(b);
	        b.setAvailable(false);
	        System.out.println("!!!!!!!!!!!!!!Book Referenced Successfully!!!!!!!");
	        log.info("Book Referenced Successfully");
		}
		else
		{
			System.out.println("Book Not Referenced");
			log.info("Book Not Referenced");
		}
	}

	@Override
	public void referenceReturnBook(Book book, boolean status) 
	{
		if(status==true)
		{
	    	BookDaoImpl.bookReferenceList.remove(book);
	        book.setAvailable(true);
	        System.out.println("!!!!!!!!!!Reference Book Returned Successfully!!!!!!!!!!!!");
	        log.info("!!!!!!!!!!Reference Book Returned Successfully!!!!!!!!!!!!!");
		}
		else
		{
			System.out.println("!!!!!!!!!!Reference Book not Returned Successfully!!!!!!!!!!!!");
			 
		}
	}
 
	
}
