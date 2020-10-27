package my.experiments.services;

public class Note {
	String text;
	
	public Note(String text) {
		this.text = text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
