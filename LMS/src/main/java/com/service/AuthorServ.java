package com.service;

import java.util.List;

import com.entites.Author;

public interface AuthorServ {
	public Author addAuthorDetails(Author author);
	public Author updateAuthorDetails(Author author) throws Throwable;
	
	public List<Author> viewAuthorsList();
	public Author viewAuthorById(int id);
	public String deleteAuthorDetails(Author author) throws Throwable;
	public   Author findByFirstName(String firstname) ; 
	public List<Author> findByEmailSorted(String email);

}
