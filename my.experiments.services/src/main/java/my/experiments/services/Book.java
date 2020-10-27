package my.experiments.services;

public class Book {
	String caption;
	Author writer;
	
	public Book(String caption, Author writer) {
		this.caption = caption;
		this.writer = writer;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public Author getWriter() {
		return writer;
	}
}
