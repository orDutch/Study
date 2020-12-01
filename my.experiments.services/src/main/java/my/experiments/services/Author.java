package my.experiments.services;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
	String name;
	String lastName;
	String patronym;
	
	@JsonCreator
	public Author(@JsonProperty("name") String name, @JsonProperty("lastName") String lastName, @JsonProperty("patronym") String patronym) {
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
