package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	}

    @RequestMapping(
    		value = "/",
    		method = RequestMethod.GET)
    public Library AsIs() {
    	myLibrary.refresh();
        return myLibrary;
    }

    @RequestMapping(
    		value = "/Books",
    		method = RequestMethod.GET)
    public List<Book> getBooks(@RequestParam(name="search", required = false) String search) {
    	myLibrary.refresh();
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
    	myLibrary.refresh();
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

    @RequestMapping(
    		value = "/Authors",
    		method = RequestMethod.POST)
    public boolean getAuthors(@RequestBody() Author newAuthor) {
    	return myLibrary.AddAuthor(newAuthor.name, newAuthor.lastName, newAuthor.patronym);
    }

    @RequestMapping(value = "/Books/{caption}",
    		method = RequestMethod.GET)
    public Book getBook(@PathVariable("caption") String caption) {
    	myLibrary.refresh();
    	for (Book b: myLibrary.books)
    		if (b.getCaption().equalsIgnoreCase(caption))
    	        return b;
    	return null;
    }

    @RequestMapping(value = "/Books",
    		method = RequestMethod.POST)
    public String getBook(@RequestBody() Book b) {
    	return myLibrary.AddBook(b.getWriter().name, b.getWriter().lastName, b.getWriter().patronym, b.getCaption());
    }

    @RequestMapping(value = "/Authors/{LastName}",
    		method = RequestMethod.GET)
    public Antology getAntology(@PathVariable("LastName") String LastName) {
    	myLibrary.refresh();
    	for (Author a: myLibrary.authors)
    		if (a.getLastName().equalsIgnoreCase(LastName))
    	        return new Antology(a, myLibrary.books);
    	return new Antology(new Author(null,LastName,null), myLibrary.books);
    }
    
    @RequestMapping(
    		value = "/AuthorsAdd",
    		method = RequestMethod.GET)
    public String getAuthors(@RequestParam(name="n", required = true) String name,
    		@RequestParam(name="ln", required = true) String lastname,
    		@RequestParam(name="pt", required = true) String patronym) {
    	return String.valueOf(myLibrary.AddAuthor(name, lastname, patronym));
    }
}
