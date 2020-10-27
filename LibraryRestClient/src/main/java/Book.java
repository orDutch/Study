import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
	String caption;
	Author writer;
	
	@JsonCreator
	public Book(@JsonProperty("caption") String caption, @JsonProperty("writer") Author writer) {
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
