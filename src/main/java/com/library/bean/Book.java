package com.library.bean;

import java.io.Serializable;

public class Book implements Serializable 
{
	private String bookName;
	private String bookSubject;
	private String authorName;
	
	private int pageNo;
	private int price;
	private int bookId;
	
	private boolean isAvailable=false;
	

	public Book() 
	{
	}
	
	public Book(String bookName,String bookSubject,String authorName,int pageNo,int price)
	{
		this.bookName=bookName;
		this.authorName=authorName;
		this.bookSubject=bookSubject;
		this.pageNo=pageNo;
		this.price=price;
		this.isAvailable = true;
	
	}
	public int getBookId()
	{
		return bookId;
	}
	public void setBookId(int bookId)
	{
		this.bookId = bookId;
	}
	
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	
	public String getBookSubject() 
	{
		return bookSubject;
	}
	public void setBookSubject(String bookSubject) 
	{
		this.bookSubject = bookSubject;
	}
	
	public String getAuthorName()
	{
		return authorName;
	}
	
	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}
	
	public int getPageNo() 
	{
		return pageNo;
	}
	public void setPageNo(int pageNo) 
	{
		this.pageNo = pageNo;
	}
	
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) 
	{
		this.isAvailable = isAvailable;
	}
	
	
	    public String toString() {
	        
	        return "Book{" +
	                "bookId=" + bookId +
	                ", bookName='" + bookName + '\'' +
	                ", author='" + authorName + '\'' +
	                ", subject='" + bookSubject + '\'' +
	                ", pages='" + pageNo + '\'' +
	                ", price=" + price +
	                ", isAvailable=" + isAvailable +
	                "}\n";
	    
	    }
}

