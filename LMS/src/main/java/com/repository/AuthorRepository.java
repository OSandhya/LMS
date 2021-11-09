package com.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entites.Author;
import com.entites.BooksIssued;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> 
{
	
	public  Author findByFirstName(String firstName) ;
	  @Query("Select authors from Author authors order by authors.firstName") 
	  List<Author> findByEmailSorted(String Email);
			
	 
}
