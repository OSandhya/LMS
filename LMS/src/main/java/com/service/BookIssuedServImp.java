package com.service;

import java.util.Date;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.BookNotFoundException;
import com.entites.Books;
import com.entites.BooksIssued;
import com.repository.BooksIssuedRepository;
import com.repository.BooksRepository;

@Service
public class BookIssuedServImp implements BookIssuedServ {
	@Autowired
	private BooksIssuedRepository rep;
	@Autowired
	private BooksRepository repo;

	@Override
	public BooksIssued addIssuedBook(BooksIssued issued) {
		
		
	  return rep.save(issued);
		
	}
	

	@Override
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) throws Throwable {
		int issueId = booksIssued.getIssueId();
		  Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");
		  BooksIssued  b1=rep.findById(issueId).orElseThrow(s1);
		  b1.setIssueId(booksIssued.getIssueId());
		  b1.setIssueDate(booksIssued.getIssueDate());
		  b1.setDueDate(booksIssued.getDueDate());
		  b1.setQuantity(booksIssued.getQuantity());	
		  rep.save(b1) ;	 
		  return rep.save(b1);

	}

	@Override
	public String deleteIssuedBooks(int issueId) throws Throwable
	{		
		 Supplier s1= ()->new BookNotFoundException("Book Does not exist in the database");		
	      BooksIssued a = rep.findById(issueId).orElseThrow(s1);
	      if(a != null)
	      {
	    		 rep.deleteById(issueId);
	    		 return "deleted";
	    		 } 
	      return "";
	}

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
	      	
		List<BooksIssued> lc1 = rep.findAll();
		return lc1;

	}

	@Override
	public BooksIssued findByIssueId(int issueId) throws Throwable
	{
		 Supplier s2= ()->new BookNotFoundException("Issued Book Does not exist in the database");
		 BooksIssued b=rep.findById(issueId).orElseThrow(s2);
		 if(b!=null)
		 {
			 rep.findById(issueId);
		 }
		  return b;
		
	}

	@Override
	public List<BooksIssued> findByQuantitySorted(int quantity) {
	
		 List<BooksIssued> lc=rep.findByQuantitySorted(quantity);
		  return lc;
		
	}
	
	

}
