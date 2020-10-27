package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Library")
public class restfull {

	private Library myLibrary;

	@Autowired
	public restfull(Library myLibrary) {
	    this.myLibrary = myLibrary;
	    this.myLibrary.authors.add(new Author("Лев","Толстой","Николаевич"));
	    this.myLibrary.books.add(new Book("Война и Мир", this.myLibrary.authors.get(0)));
	    this.myLibrary.books.add(new Book("Анна Каренина", this.myLibrary.authors.get(0)));
	    this.myLibrary.books.add(new Book("Живой труп", this.myLibrary.authors.get(0)));
	    this.myLibrary.authors.add(new Author("Фёдор","Достоевский","Михайлович"));
	    this.myLibrary.books.add(new Book("Братья Карамазовы", this.myLibrary.authors.get(1)));
	    this.myLibrary.books.add(new Book("Идиот", this.myLibrary.authors.get(1)));
	    this.myLibrary.books.add(new Book("Бесы", this.myLibrary.authors.get(1)));
	    this.myLibrary.authors.add(new Author("Максим","Горький",""));
	    this.myLibrary.books.add(new Book("На дне", this.myLibrary.authors.get(2)));
	    this.myLibrary.books.add(new Book("Старуха Изергиль", this.myLibrary.authors.get(2)));
	    this.myLibrary.books.add(new Book("Фома Гордеев", this.myLibrary.authors.get(2)));
	}

    @RequestMapping(
    		value = "/",
    		method = RequestMethod.GET)
    public Library AsIs() {
        return myLibrary;
    }

    @RequestMapping(
    		value = "/Books",
    		method = RequestMethod.GET)
    public List<Book> getBooks(@RequestParam(name="search", required = false) String search) {
    	if (search != null) {
    		List<Book> sr = new ArrayList<Book>();
    		for (Book b : myLibrary.books)
    			if (b.getCaption().toLowerCase().contains(search.toLowerCase()))
    				sr.add(b);
    		return sr;
    	} else
    		return myLibrary.books;
    }

    @RequestMapping(
    		value = "/Authors",
    		method = RequestMethod.GET)
    public List<Author> getAuthors(@RequestParam(name="search", required = false) String search) {
    	if (search != null) {
    		List<Author> sr = new ArrayList<Author>();
    		for (Author a : myLibrary.authors)
    			if (a.getLastName().toLowerCase().contains(search.toLowerCase())
    			 || a.getName().toLowerCase().contains(search.toLowerCase())
    			 || a.getPatronym().toLowerCase().contains(search.toLowerCase()))
    				sr.add(a);
    		return sr;
    	} else
    		return myLibrary.authors;
    }

    @RequestMapping(value = "/Books/{caption}",
    		method = RequestMethod.GET)
    public Book getBook(@PathVariable("caption") String caption) {
    	for (Book b: myLibrary.books)
    		if (b.getCaption().equalsIgnoreCase(caption))
    	        return b;
    	return null;
    }

    @RequestMapping(value = "/Authors/{LastName}",
    		method = RequestMethod.GET)
    public Antology getAntology(@PathVariable("LastName") String LastName) {
    	for (Author a: myLibrary.authors)
    		if (a.getLastName().equalsIgnoreCase(LastName))
    	        return new Antology(a, myLibrary.books);
    	return new Antology(new Author(null,LastName,null), myLibrary.books);
    }
}
