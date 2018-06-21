package com.book.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Books {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private short id;
	@Size(min = 2, max = 80)
	private String bookTitle;
	@Size(min = 2, max = 80)
	private String genre;
	@Size(min = 2, max = 4)
	private int yearPublished; 
	

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Set<Authors> authors = new HashSet<Authors>();
	
	public Books() {
		
	}
	
	public Books(String bookTitle, String genre, int yearPublished) {
		this.bookTitle = bookTitle;
		this.genre = genre;
		this.yearPublished = yearPublished;
	}
	
	public String getBookTitle () {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

}

