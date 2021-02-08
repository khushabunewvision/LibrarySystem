package com.library.dao.impl;

import java.util.ArrayList;

import com.library.bean.Book;
import com.library.dao.BookDao;
import com.library.service.impl.BookServiceImpl;

import org.apache.log4j.Logger;

public class BookDaoImpl implements BookDao
{
	static Logger log=Logger.getLogger(BookIssueDaoImpl.class);
	public static ArrayList<Book> bookList=new ArrayList<>();
	public static ArrayList<Book> bookIssueList=new ArrayList<>();
	public static ArrayList<Book> bookReferenceList=new ArrayList<>();
	
	boolean status=false;

	@Override
	public boolean addBook(Book book) 
	{
		if(book.getBookId()!=0)
		{
			bookList.add(book);
			status=true;	
		}
		else
		{
			status=false;
		}
		
		return status;
	}

	@Override
	public void getAllBook()
	{
		if(bookList.isEmpty())
		{
			System.out.println("****Nothing To Display****");
		}
		else
		{
			System.out.println("*******Displaying All Books******");
			for(Book b:bookList)
			{
				System.out.println(b.toString());
			}
		}
	}

	
	
	
	
	@Override
	public ArrayList<Book> searchByBookName(String bookName) 
	{
		ArrayList<Book> arrayList=new ArrayList<Book>();
		
		for(Book b1: bookList)
		{
			if(b1.getBookName().contains(bookName))
			{
				arrayList.add(b1);
			}
		}
		return arrayList;
	
	}
	
	public ArrayList<Book> searchByAuthorName(String authorName) 
	{
		ArrayList<Book> arrayList=new ArrayList<Book>();
		
		for(Book b1: bookList)
		{
			if(b1.getAuthorName().contains(authorName))
			{
				arrayList.add(b1);
			}
		}
		return arrayList;
	
	}
	
	
	public void issuedBooks()//librarian
    {
    	if(bookIssueList.isEmpty())
		{
			System.out.println("****No Books Issued****");
		}
		else
		{
			for(Book b:bookIssueList)
			{
				System.out.println(b.toString());
			}
		}
    }
	
	
	public void getAvailability()		//for students
	{
		ArrayList<Book> arrayList=new ArrayList<Book>();
		
		if(bookList.isEmpty())
		{
			System.out.println("****Nothing To Display****");
		}
		else
		{
			System.out.println("******* Displaying Available Books******");
			for(Book b1: bookList)
			{
				if(b1.isAvailable()==true)
				{
					System.out.println(b1.toString());
				}
			}
			
		}
		
	}
	

	@Override
	public void getBookCount() 
	{
		System.out.println("Books Prensent in the Library Are:- "+bookList.size());
	}

	@Override
	public ArrayList<Book> studentSearchByBookName(String bookName)
	{
		ArrayList<Book> arrayList=new ArrayList<Book>();
		for(Book b1: bookList)
		{
			if((b1.isAvailable()==true) &&(b1.getBookName().contains(bookName)))
			{
				arrayList.add(b1);
			}
		}
		return arrayList;
	}

	@Override
	public void referencedBook()
	{
		if(bookIssueList.isEmpty())
		{
			System.out.println("****No Books taken for reference****");
		}
		else
		{
			for(Book b:bookReferenceList)
			{
				System.out.println(b.toString());
			}
		}
	}

	
	
}
