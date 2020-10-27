package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Desk")
public class NotificationDesk {
	
	List<Note> Notes;
	
	public NotificationDesk() {
		Notes = new ArrayList<Note>();
	}

	@RequestMapping(
    		value = "/Notes",
    		method = RequestMethod.GET)
	public List<Note> getNotes() {
		return Notes;
	}

	@RequestMapping(
    		value = "/Notes",
    		method = RequestMethod.POST)
	public String postNotes(@RequestBody String Message) {
		Notes.add(new Note(Message));
		return "Ok";
	}

	@RequestMapping(
    		value = "/Notes",
    		method = RequestMethod.DELETE)
	public String deleteNotes(@RequestBody String Message) {
		for(Note n: Notes)
			if (n.text.equals(Message)) {
				Notes.remove(n);
				return "Ok";
			}
		return "Not found";
	}
}
