package com.library.dao;

import java.io.IOException;

public interface BookIssueDao 
{
	public void requestIssueBook() throws IOException;
	public void returnBook() throws IOException;
	public void requestReferenceBook() throws IOException;
	public void returnReferenceBook() throws IOException;
	
	
	
}
