package com.service;

import java.util.List;

import com.entites.BooksIssued;

public interface BookIssuedServ  {
	public BooksIssued addIssuedBook(BooksIssued issued) throws Throwable;
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable;
	
	public List<BooksIssued> viewBooksIssuedList();
	
    public	List<BooksIssued> findByQuantitySorted(int quantity);
    public 	BooksIssued findByIssueId(int issueId) throws Throwable;
	
	String deleteIssuedBooks(int issueId) throws Throwable;
	

}
