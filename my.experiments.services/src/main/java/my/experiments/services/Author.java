package my.experiments.services;

public class Author {
	String name;
	String lastName;
	String patronym;
	
	public Author(String name, String lastName, String patronym) {
		this.name = name;
		this.lastName = lastName;
		this.patronym = patronym;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPatronym() {
		return patronym;
	}
}
