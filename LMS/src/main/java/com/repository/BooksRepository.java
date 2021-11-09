package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entites.Books;

public interface BooksRepository extends JpaRepository<Books,Long>{
	   
		
		@Query("Select books from Books books order by books.title ")
		List<Books> findBookByTitle(String keyword);
		
	  
		
		@Query("Select books from Books books order by books.subject")
		List<Books> findBookBySubject(String keyword);
		

}
