package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

public class Antology {
	Author wtiter;
	List<Book> books;
	
	public Antology(Author writer, List<Book> abooks) {
		this.books = new ArrayList<Book>();
		this.wtiter = writer;
		for (Book b: abooks)
			if (b.writer == writer)
				this.books.add(b);
	}

	public Author getWriter() {
		return wtiter;
	}
	
	public List<Book> getBooks() {
		return books;
	}
}
