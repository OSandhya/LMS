package com.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="books")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookid")
	private Long bookid;
	 @Column(name="title",length=250,nullable=false)
	 @NotNull(message="title cannot be null")
	private String title;
	 @Column(name="subject",length=250,nullable=false)
	 @NotNull(message="subject cannot be null")
	private String subject;
	 @Column(name="quantity",nullable=false)
	 @NotNull(message = "quantity Should Not Be Null") 
	private int quantity;
	 @NotNull(message = "Price should not be blank")

	private double price;
	@NotNull(message = "Bookcost should not be blank")	
	private double book_cost;
	@NotNull
	@Column(name = "shelf_details", length = 20, nullable = false)
	private String shelf_details;
	@NotNull	
	private int published_year;
	@NotNull
	private String isbn_code;
	 
	
	  @ManyToOne
	  private Author authors;
		
		
		  @OneToMany(mappedBy="books")
		  private List<BooksIssued> bookissued;
			
			 @ManyToOne(cascade=CascadeType.MERGE)
			 private Admin admin; 
			 
	public Long getBookid() {
		return bookid;
	}
	public void setBookid(Long bookid)
	{
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	  public int getPublished_year()
	  { 
		  return published_year; 
	} 
	  public void  setPublished_year(int published_year) 
	  {
		  this.published_year = published_year;
	  }
	 
	public String getIsbn_code() {
		return isbn_code;
	}
	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}
	public double getBook_cost() {
		return book_cost;
	}
	public void setBook_cost(double book_cost) {
		this.book_cost = book_cost;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShelf_details() {
		return shelf_details;
	}
	public void setShelf_details(String shelf_details) {
		this.shelf_details = shelf_details;
	}

	
	  public Admin getAdmin() { return admin; } public void setAdmin(Admin admin) {
	  this.admin = admin; }
	 
	 public Author getAuthors()
	  { 
		  return authors; 
		}
	  public void setAuthors(Author authors) 
	  {
		  this.authors = authors; 
	 }	


}
