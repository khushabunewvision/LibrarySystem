package com.library.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.library.bean.Book;
import com.library.bean.User;
import com.library.dao.BookDao;
import com.library.dao.BookIssueDao;
import com.library.dao.impl.BookDaoImpl;
import com.library.dao.impl.BookIssueDaoImpl;
import com.library.service.BookService;
import com.library.service.LoginValidationService;
import com.library.service.impl.BookServiceImpl;
import com.library.service.impl.LoginValidationServiceImpl;

public class TestMain
{
	static Logger log=Logger.getLogger(TestMain.class);
	public static int bookId=0;
	public static int userId=0;
	private String bookName;
	private String bookSubject;
	private String authorName;
	private int pageNo;
	private int price;
	private static Scanner sc=new Scanner(System.in);
	private static InputStreamReader isr=new InputStreamReader(System.in);
	private static BufferedReader br= new BufferedReader(isr);
	
	ArrayList<Book> arrayList=new ArrayList<Book>();
	BookDao bookDao=new BookDaoImpl(); 
	BookService bookService=new BookServiceImpl();
	Book book=new Book();
	BookIssueDao bookIssueDao=new BookIssueDaoImpl();
	LoginValidationService loginValidationService =new LoginValidationServiceImpl();
	
	public static void main(String[] args) throws IOException 
	{
		LoginValidationService loginValidationService =new LoginValidationServiceImpl();
		TestMain test=new TestMain();
		int i=4;
		log.info("******Welcome To Knowledge Wala Library******");
		
			while(true)
			{
				
				i=loginValidationService.credententials();
				while(true)
				{
					if(i==1)
					{
						test.librarianShowMenu();
						
					}
					else if(i==2)
					{
						test.studentShowMenu();
						
					}
					else if(i==3)
					{
						System.out.println("*****Wrong credentials******");
						log.error("*****Wrong credentials******");
						System.out.println("***Please Enter Right Credentials***");
						break;
					}
				}//inner while
			}//outer while
	}
	
	
	
	// Student Switch Case
	private void studentShowMenu() throws IOException
	{
		int choice=0;
		System.out.println("1. Get All Book List");
		System.out.println("2. See Available Books");
		System.out.println("3. Search By BookName which are available ");
		System.out.println("4. Issue Book");
		System.out.println("5. Return Book");
		System.out.println("6. Reference Book");
		System.out.println("7. Return Reference Book");
		System.out.println("8. Return to Login");
		System.out.println("0. Exit");
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		
		switch(choice)
		{
			case 1://Get All Book List
			{
				bookDao.getAllBook();
				break;
			}
			case 2://See Available Book
			{
				bookDao.getAvailability();
				break;
			}
			case 3://Search By BookName which are available
			{
				System.out.println("Enter Book Name");
				bookName=br.readLine();
				arrayList=bookDao.studentSearchByBookName(bookName);
				bookService.searchStatus(arrayList);
				break;
			}
			case 4:// Issue Book
			{
				bookIssueDao.requestIssueBook();
				break;
			}
			case 5: //Returned Book
			{
				bookIssueDao.returnBook();
				break;
			}
			case 6: //Reference Book
			{
				bookIssueDao.requestReferenceBook();
				break;
			}
			case 7://Return reference book
			{
				bookIssueDao.returnReferenceBook();
				break;
			}
			case 8://Return to Login
			{
				System.out.println("**You Logged out Successfully**");
				log.info("Student Logged Out successfully");
				logout();
			}
			
			case 0:
			{
				System.out.println("Exit!!!!");
				log.info("Exit");
				System.exit(0);
			}
			
			default:
			{
				System.out.println("Wrongchoice");
				studentShowMenu();
				break;
			}
		}
	}
	
	private void librarianShowMenu() throws IOException
	{
		boolean status;
		int choice;
		System.out.println("1. Add Book");
		System.out.println("2. Get All Books Information");
		System.out.println("3. Search By BookName ");
		System.out.println("4. Search By AuthorName");
		System.out.println("5. Issued books by Students");
		System.out.println("6. Book Count In Library");
		System.out.println("7. Return to Login");
		System.out.println("0. Exit");
		System.out.println("Enter Your Choice");
		choice=sc.nextInt();
		
		switch(choice)
		{
			case 1:
			{
				
				book=addBookDetails();
				status=bookDao.addBook(book);
				bookService.addBookStatus(status);
				break;
			}//case 1
			
			case 2:
			{
				//Display All Book
				
				bookDao.getAllBook();
				break;
			}//case 2 Get all book Information
			
			case 3:
			{
				//3.searchByName--Librarian
				System.out.println("******Searching Book By Name******");
				System.out.println("Enter Book Name");
				bookName=br.readLine();
				arrayList=bookDao.searchByBookName(bookName);
				bookService.searchStatus(arrayList);
				break;
			}//searchByName
			
			case 4:
			{
				//3.SearchByAuthor
				System.out.println("Enter Book Author Name");
				authorName=br.readLine();
				arrayList=bookDao.searchByAuthorName(authorName);
				bookService.searchStatus(arrayList);
				break;
			}//searchByAuthorName
			case 5:
			{
				//librarian----loaned Books to student
				bookDao.issuedBooks();
				break;
			}//List of Books Issued By Students
			
			case 6:
			{
				bookDao.getBookCount();
				break;
			}// Books Count in Library
			
			case 7://Return to Login
			{
				System.out.println("**You Logged out Successfully**");
				log.info("Admin Logged Out successfully");
				logout();
			}//case 7
			
			case 0:
			{
				System.out.println("Exit!!!!");
				log.info("Exit");
				System.exit(0);
			}
			default:
			{
				System.out.println("Wrongchoice");
				librarianShowMenu();
				break;
			}
				
		}//switch
	}//librarianShowMenu
	
	public Book addBookDetails() throws IOException
	{
		System.out.println("Adding Book Details------------");
		
		System.out.println("Enter Book name");
		bookName=br.readLine();
		
		System.out.println("Enter Book Subject");
		bookSubject=br.readLine();
		
		System.out.println("Enter author Name");
		authorName=br.readLine();
		
		System.out.println("Enter page number");
		pageNo=sc.nextInt();
		
		System.out.println("Enter Price ");
		price=sc.nextInt();
		
		bookId++;
		
		Book book=new Book(bookName,bookSubject,authorName,pageNo,price);
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setAuthorName(authorName);
		book.setBookSubject(bookSubject);
		book.setPageNo(pageNo);
		book.setPrice(price);
		return book;
	}
	
	private void logout() throws IOException
	{
		while(true)
		{
			int i;
			i=loginValidationService.credententials();
			while(true)
			{
				if(i==1)
				{
					librarianShowMenu();
					
				}
				else if(i==2)
				{
					studentShowMenu();
					
				}
				else if(i==3)
				{
					System.out.println("*****Wrong credentials******");
					System.out.println("***Please Enter Right Credentials***");
					break;
				}
			}//inner--while
		}//outer--while
		
	}
	
	private User addUserDetails() throws IOException
	{
		System.out.println("Adding User Details------------");
		
		System.out.println("Enter Username");
		String userName=br.readLine();
		
		System.out.println("Enter Password");
		String password=br.readLine();
		
		System.out.println("Enter Role either Admin or Student");
		String userType=br.readLine();
		
		userId++;
		
		User user=new User(userName, password, userType);
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserType(userType);
		return user;
	}
	

}//class
