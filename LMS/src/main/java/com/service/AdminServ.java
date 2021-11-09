package com.service;

import java.util.List;

import com.entites.Admin;
import com.entites.Books;
import com.entites.BooksOrder;
import com.entites.DamagedBooks;
import com.entites.Users;

public interface AdminServ {
	public Admin addAdminDetails(Admin ad);
	public Books addBooksByAdmin(Books b);
	public Users ValidateUserDetails(Users user) throws Throwable;
	
	  public Books updateBooksByAdmin(Books books) throws Throwable;
	  
	  public Long removeBooksByAdmin(Long bookid);
	  
	  public BooksOrder addBookOrderByAdmin(BooksOrder booksOrder);
	  
	  public BooksOrder updateBookOrderByAdmin(BooksOrder booksOrder) throws Throwable;
	  
	  public String removeBookOrderByAdmin(int orderId);
	  
	  public List<DamagedBooks> viewDamagedBooksListByAdmin();
	  
	  public DamagedBooks viewDamagedBookById(int id)throws Throwable; public
	  DamagedBooks addDamagedBooksByAdmin( DamagedBooks d); 
	  public List<Books> searchBookByTitleByAdmin(String title);
	  
	  public List<Books> searchBookBySubjectByAdmin(String subject) ;
	 

}


