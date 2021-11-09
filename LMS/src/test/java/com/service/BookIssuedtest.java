package com.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entites.BooksIssued;
import com.repository.BooksIssuedRepository;
@SpringBootTest
class BookIssuedtest {

	@Autowired
	BookIssuedServImp bookissuedserv;
	
	@MockBean
	BooksIssuedRepository repo;

	@Test
	void testAddIssuedBook() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(1);
		Date current = new Date();
		bi.setIssueDate(current);
		Date d = new Date();
		bi.setDueDate(d);
		bi.setQuantity(2);
		Mockito.when(repo.save(bi)).thenReturn(bi);
	
		assertThat(bookissuedserv.addIssuedBook(bi).equals(bi));
	}
	

	
	/*
	 * @Test
	 * 
	 * void testUpdateIssuedBookDetails() throws Throwable { BooksIssued bi =new
	 * BooksIssued(); bi.setIssueId(0); Date D = new Date(); bi.setIssueDate(D);
	 * Date D1 = new Date(); bi.setDueDate(D1); bi.setQuantity(0);
	 * 
	 * 
	 * Optional<BooksIssued> b2 = Optional.of(bi);
	 * Mockito.when(repo.findById(1)).thenReturn(b2);
	 * Mockito.when(repo.save(bi)).thenReturn(bi);
	 * 
	 * 
	 * assertThat(bookissuedserv.updateIssuedBookDetails(bi)).isEqualTo(bi); }
	 */
	

	@Test
	void testDeleteIssuedBooks() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(4);
		Date da = new Date();
		bi.setIssueDate(da);
		Date d2 = new Date();
		bi.setDueDate(d2);
		bi.setQuantity(4);
		Optional<BooksIssued> b2=Optional.of(bi);
		Mockito.when(repo.findById(4)).thenReturn(b2);
		Mockito.when(repo.existsById(bi.getIssueId())).thenReturn(false);
		assertFalse(repo.existsById(bi.getIssueId()));
		
	}

	@Test
	void testViewBooksIssuedList() {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(2);
		Date current = new Date();
		bi.setIssueDate(current);
		Date c1 = new Date();
		bi.setDueDate(c1);
		bi.setQuantity(2);
		
		BooksIssued bi1 = new BooksIssued();
		bi1.setIssueId(1);
		Date c2 = new Date();
		bi1.setIssueDate(c2);
		Date c3 = new Date();
		bi1.setDueDate(c3);
		bi1.setQuantity(1);
		
		
		List<BooksIssued> bookissueList = new ArrayList<BooksIssued>();
		bookissueList.add(bi);
		bookissueList.add(bi1);
		
		Mockito.when(repo.findAll()).thenReturn(bookissueList);
		assertThat(bookissuedserv.viewBooksIssuedList()).isEqualTo(bookissueList);
		
	}

	@Test
	void testFindByIssueId() throws Throwable {
		BooksIssued bi = new BooksIssued();
		bi.setIssueId(1);
		Date cur = new Date();
		bi.setIssueDate(cur);
		Date cu = new Date();
		bi.setDueDate(cu);
		bi.setQuantity(2);
		
		Optional<BooksIssued> c2 = Optional.of(bi);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		assertThat(bookissuedserv.findByIssueId(1)).isEqualTo(bi);
	
	}
	/*
	 * @Test void testviewBooksIssuedList() {
	 * assertNotNull(bookissuedserv.viewBooksIssuedList()); }
	 */


}
