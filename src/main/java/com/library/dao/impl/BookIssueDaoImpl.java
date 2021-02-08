package com.library.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import com.library.bean.Book;
import com.library.dao.BookIssueDao;
import com.library.service.BookService;
import com.library.service.impl.BookServiceImpl;
import org.apache.log4j.Logger;

public class BookIssueDaoImpl implements BookIssueDao
{
	static Logger log=Logger.getLogger(BookIssueDaoImpl.class);
	Scanner sc=new Scanner(System.in);
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader br= new BufferedReader(isr);
	BookService bookService=new BookServiceImpl();
	boolean status=false;
	
	
	public void requestIssueBook() throws IOException
	{
        System.out.println("Please enter the Book ID of the book you want to issue: ");
        int  bookId =sc.nextInt();
        boolean flag = false;
        boolean flag1 = false;
       
        Book book1 = null;
        for (Book book : BookDaoImpl.bookList) 
        {
            if (book.getBookId() == bookId)
            {
                System.out.println(book);
                if(book.isAvailable()) 
                {
                    flag = true;
                    book1= book;
                }
                flag1 = true;
            }
        }
        if (!flag1)
        {
            System.out.println("Book with this id doesnt exist. Check the Id again!!");
            return;
        }
        else if(!flag)
        {
            System.out.println("Sorry!! The book is currently issued to someone else.");
            return;
        }
        System.out.println("Do you want the above book to be issued? (Y/N)");
        if(br.readLine().equals("y"))
        {
        	status=true;
        	bookService.issueBook(book1,status);
        }
        else
        {
        	status=false;
        }
	 }
	
	public void returnBook() throws IOException
	 {
		System.out.println("Please enter the Book ID of the book you want to return: ");
		int bookId = sc.nextInt();
		boolean flag = false;
		Book book1 = null;
		
		for (Book book :BookDaoImpl.bookIssueList) 
		{
		    if (book.getBookId() ==bookId && book.isAvailable()==false)
		    {
		        System.out.println(book);
		            flag = true;
		            book1 = book;
		    }
		}
		if (!flag) 
		{
		    System.out.println("Wrong info. Check the Id again!!");
		    
		}
		
		System.out.println("Do you want the above book to be returned? (Y/N)");
		
		if(br.readLine().equalsIgnoreCase("y"))
		{
			status = true;
		    bookService.confirmReturnBook(book1,status);
		}
		else
		{
			status=false;
		}
			
	    }
	
	@Override
	public void requestReferenceBook() throws IOException 
	{

        System.out.println("Please enter the Book ID of the book : ");
        int  bookId =sc.nextInt();
        boolean flag = false;
        boolean flag1 = false;
       
        Book book1 = null;
        for (Book book : BookDaoImpl.bookList) 
        {
            if (book.getBookId() == bookId)
            {
                System.out.println(book);
                if(book.isAvailable()) 
                {
                    flag = true;
                    book1= book;
                }
                flag1 = true;
            }
        }
        if (!flag1)
        {
            System.out.println("Book with this id doesnt exist. Check the Id again!!");
            return;
        }
        else if(!flag)
        {
            System.out.println("Sorry!! The book is currently issued to someone else.");
            return;
        }
        System.out.println("Do you want the above book to be issued? (Y/N)");
        if(br.readLine().equals("y"))
        {
        	status=true;
        	bookService.referenceBook(book1,status);
        }
        else
        {
        	status=false;
        }
	}

	@Override
	public void returnReferenceBook() throws IOException 
	{
		System.out.println("Please enter the Book ID of the book you want to return: ");
		int bookId = sc.nextInt();
		boolean flag = false;
		Book book1 = null;
		
		for (Book book :BookDaoImpl.bookReferenceList) 
		{
		    if (book.getBookId() ==bookId && book.isAvailable()==false)
		    {
		        System.out.println(book);
		            flag = true;
		            book1 = book;
		    }
		}
		if (!flag) 
		{
		    System.out.println("Wrong info. Check the Id again!!");
		    
		}
		
		System.out.println("Do you want the above book to be returned? (Y/N)");
		
		if(br.readLine().equalsIgnoreCase("y"))
		{
			status = true;
		    bookService.referenceReturnBook(book1,status);
		}
		else
		{
			status=false;
		}
	}
	
}
