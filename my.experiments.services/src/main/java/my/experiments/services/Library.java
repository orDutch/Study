package my.experiments.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Library {
	List<Author> authors;
	List<Book> books;
	
	public boolean AddAuthor(String name, String lastname, String patronym) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?currentSchema=education", "postgres", "123456");
			PreparedStatement st = c.prepareStatement("insert into authors (name, lastname, patronym) values (?, ?, ?);");
			st.setString(1, name);
			st.setString(2, lastname);
			st.setString(3, patronym);
			st.execute();
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public String AddBook(String name, String lastname, String patronym, String caption) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?currentSchema=education", "postgres", "123456");
			PreparedStatement st1 = c.prepareStatement("select id from authors where name like ? and lastname like ? and patronym like ?;");
			st1.setString(1, name);
			st1.setString(2, lastname);
			st1.setString(3, patronym);
			ResultSet res = st1.executeQuery();
			if (!res.next())
				return "Автор " + lastname + " " + name + " " + patronym + " не найден.";
			PreparedStatement st2 = c.prepareStatement("insert into books (author, caption) values (?, ?);");
			st2.setInt(1, res.getInt("id"));
			st2.setString(2, caption);
			st2.execute();
		} catch (ClassNotFoundException e) {
			return "Ошибка драйвера.";
		} catch (SQLException e) {
			return "Ошибка SQL: " + e.getMessage();
		}
		return "ОК";
	}
	
	public boolean refresh() {
		books.clear();
		authors.clear();
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?currentSchema=education", "postgres", "123456");
			Statement st = c.createStatement();
			ResultSet result = st.executeQuery("select id, name, lastname, patronym from authors");
			while (result.next()) {
			    authors.add(new Author(result.getString("name"), result.getString("lastname"), result.getString("patronym")));
			    PreparedStatement st2 = c.prepareStatement("select caption from books where author = ?");
			    st2.setInt(1, result.getInt("id"));
			    ResultSet result2 = st2.executeQuery();
			    while (result2.next()) {
			    	books.add(new Book(result2.getString("caption"), authors.get(authors.size()-1)));
			    }			
			}	
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SQLException e) {
			return false;			
		}
		return true;
	}
	
	public Library() {
		this.authors = new ArrayList<Author>();
		this.books = new ArrayList<Book>();
		refresh();
	}
	
	public List<Author> getAuthors() {
		return authors; 
	}
	
	public List<Book> getBooks() {
		return books; 
	}
}
