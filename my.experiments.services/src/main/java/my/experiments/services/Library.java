package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Library {
	List<Author> authors;
	List<Book> books;
	
	public Library() {
		this.authors = new ArrayList<Author>();
		this.books = new ArrayList<Book>();
	}
	
	public List<Author> getAuthors() {
		return authors; 
	}
	
	public List<Book> getBooks() {
		return books; 
	}
}
