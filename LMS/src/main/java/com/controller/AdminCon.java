package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entites.Admin;
import com.entites.Books;
import com.entites.BooksOrder;
import com.entites.DamagedBooks;
import com.entites.Users;
import com.service.AdminServ;
import com.service.AdminServImp;



@RestController
@RequestMapping("/api")
public class AdminCon {
	@Autowired
	private AdminServImp adminservice;
	@PostMapping("/admindetails")
	public ResponseEntity<Admin> addAdminDetails(@RequestBody Admin admin) {
		Admin b1 = adminservice.addAdminDetails(admin);
		ResponseEntity re = new ResponseEntity<Admin>(b1, HttpStatus.OK);
		return re;
	}
	

	  @PostMapping("/addBooksByAdm") 
	  public ResponseEntity<Books> addBooksByAdm(@RequestBody Books book) 
	  {
		  Books b1 = adminservice.addBooksByAdmin(book);
		  ResponseEntity re = new  ResponseEntity<Books>(b1, HttpStatus.OK);
		  return re; 
		  }
	  
	  @PutMapping(path = "/updateBooksByAdm") 
	  public ResponseEntity<Books> updateBooksByAdm(@RequestBody Books book) throws Throwable 
	  { 
		  Books b1 =  adminservice.updateBooksByAdmin(book);
	  
	  ResponseEntity re = new ResponseEntity<Books>(b1, HttpStatus.OK); 
	  return re;
	  }
	  
	  @DeleteMapping(path = "/deleteBooks/{eid}") 
	  public ResponseEntity<String> deleteByIdByAdm(@PathVariable long bookid) 
	  { 
		  adminservice.removeBooksByAdmin(bookid);
	  
	  ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
	  return re; 
	  }
	  
	  @PostMapping("/addBooksOrder") 
	  public ResponseEntity<BooksOrder> addBooksOrder(@RequestBody BooksOrder booksOrder) 
	  {
		  BooksOrder b1 =  adminservice.addBookOrderByAdmin(booksOrder); 
		  ResponseEntity re = new ResponseEntity<BooksOrder>(b1, HttpStatus.OK);
		  return re; 
		  }
	  
	  @PutMapping(path = "/updateBooksOrderByAdm") 
	  public ResponseEntity<BooksOrder> updateBookByAdmin(@RequestBody BooksOrder booksOrder) throws Throwable 
	  { 
		  BooksOrder  b1 = adminservice.updateBookOrderByAdmin(booksOrder);
	  
	  ResponseEntity re = new ResponseEntity<BooksOrder>(b1, HttpStatus.OK);
	  return  re; 
	  }
	  
	  @DeleteMapping(path = "/deleteBooksOrderByAdm/{eid}")
	  public ResponseEntity<String> deleteById1(@PathVariable int eid) {
	  adminservice.removeBookOrderByAdmin(eid);
	  
	  ResponseEntity re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
	  return re;
	  }
	  
	  @GetMapping("/SearchBookTitleByAdm/{btitle}") 
	  public ResponseEntity<List<Books>> searchBookByTitleByAdm(@PathVariable String btitle)
	  {
		  List<Books> c = adminservice.searchBookByTitleByAdmin(btitle);
		  ResponseEntity re = new  ResponseEntity<List<Books>>(c, HttpStatus.OK); 
		  return re; 
		  
	  }
	  
	  @GetMapping("/SearchBookSubjectByAdm/{bsubject}") 
	  public ResponseEntity<List<Books>> searchBookBySubjectByAdm(@PathVariable String bsubject) 
	  { 
		  List<Books> c = adminservice.searchBookBySubjectByAdmin(bsubject);
	  ResponseEntity re = new ResponseEntity<List<Books>>(c, HttpStatus.OK); return
	  re; }
	  
	  @PostMapping("/addDamagedBooksByAdm//{eid}") 
	  public ResponseEntity<DamagedBooks> addDamagedBooksByAdm(@RequestBody DamagedBooks DamagedBooks)
	  {
		  DamagedBooks b1 =  adminservice.addDamagedBooksByAdmin(DamagedBooks);
		  ResponseEntity re = new  ResponseEntity<DamagedBooks>(b1, HttpStatus.OK); 
		  return re; 
	  }
	  
	  @GetMapping("/getDamagedBooksByAdm") 
	  public ResponseEntity<List<DamagedBooks>>	 getDamagedBooksByAdm() 
	  { 
		  List<DamagedBooks> lc1 = adminservice.viewDamagedBooksListByAdmin(); 
		  ResponseEntity re = new ResponseEntity<List<DamagedBooks>>(lc1, HttpStatus.OK); 
		  return re; 
		  }
	  
	  @GetMapping(path = "/getDamagedBooks/{cid}")
	  public ResponseEntity<DamagedBooks> getDamagedBooksIdByAdm(@PathVariable int cid) throws
	  Throwable { DamagedBooks c1 = adminservice.viewDamagedBookById(cid);
	  
	  ResponseEntity re = new ResponseEntity<DamagedBooks>(c1, HttpStatus.OK);
	  return re; }
	 
	@PostMapping("/usersvalidate")
	  public ResponseEntity<Users> ValidateUserDetails(@RequestBody Users user) throws Throwable
	   
	   {
		   Users login=adminservice.ValidateUserDetails(user);
		   ResponseEntity re = new ResponseEntity<Users>(login,HttpStatus.OK);
		   return re;
	   }

}


