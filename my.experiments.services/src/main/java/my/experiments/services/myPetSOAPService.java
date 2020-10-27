package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;

@WebService
public class myPetSOAPService {
	private petLife life;

	@Autowired
	public myPetSOAPService(petLife life) {
		this.life = life;
	}
	
	@WebMethod
	@WebResult(name="KittySays")
	public String sayHello(@WebParam(name = "name") String name) {
		return "Hello, " + (name!=null? name: "World");
	}
	
	@WebMethod
	@WebResult(name="Kitty")
	public LiveMetrics feel() {
		return life.getState();
	}
	
	@WebMethod
	@WebResult(name="Kitty")
	public String feed() {
		if (life.getState().getHealth() < 1)
			return ".+.";
		if (life.feed())
			return "Yum!";
		else
			return "Oops...";
	}
	
	@WebMethod
	@WebResult(name="Kitty")
	public String give_drink() {
		if (life.getState().getHealth() < 1)
			return ".+.";
		if (life.give_drink())
			return "Mmm!";
		else
			return "Aw...";
	}
	
	@WebMethod
	@WebResult(name="Kitty")
	public String play() {
		if (life.getState().getHealth() < 1)
			return ".+.";
		if (life.play())
			return "Awesom!!!";
		else
			return "Eek...";
	}
	
	@WebMethod
	@WebResult(name="Kitty")
	public String treat() {
		if (life.getState().getHealth() < 1)
			return ".+.";
		if (life.treat())
			return "Phew!!!";
		else
			if (life.getState().getHealth() > 0)
				return "Ouch!!!";
			else
				return ".+.";
	}
}
