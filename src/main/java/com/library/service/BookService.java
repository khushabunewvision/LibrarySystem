package com.library.service;

import java.util.ArrayList;

import com.library.bean.Book;

public interface BookService 
{
	public void addBookStatus(boolean status);
	public void searchStatus(ArrayList<Book> book);
	public void issueBook(Book b,boolean status);
	public void confirmReturnBook(Book book,boolean status);
	public void referenceBook(Book b,boolean status);
	public void referenceReturnBook(Book book,boolean status);
	
}
