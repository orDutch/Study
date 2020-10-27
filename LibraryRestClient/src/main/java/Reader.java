import javax.ws.rs.client.ClientBuilder;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class Reader {

	public static void main(String[] args) {
		Book b = ClientBuilder.newBuilder()
				.register(JacksonJsonProvider.class)
				.build()
				.target("http://localhost")
				.path("Library/Books/Анна Каренина")
				.request("application/json")
				.header("Content-Type","application/json")
				.get(Book.class);
		System.out.print(b.caption);

	}

}
