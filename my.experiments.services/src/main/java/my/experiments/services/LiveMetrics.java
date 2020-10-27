package my.experiments.services;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Kitty")
public class LiveMetrics {
    private int health;
    private int hunger;
    private int thirst;
    private int infection;
    private int mood;
    private String face;
    
    private List<String> MoodArray = new ArrayList<String>();
    
    public LiveMetrics() {
    	MoodArray.add("unhappy");
    	MoodArray.add("borring");
    	MoodArray.add("normal");
    	MoodArray.add("joyful");
    	MoodArray.add("happy");
    	health = 100;
    	hunger = 0;
    	thirst = 0;
    	infection = 0;
    	mood = 3;    	
    }
 
    public int getHealth() {
        return health;
    }
 
    public void setHealth(int health) {
        this.health = health;
    }
 
    public int getHunger() {
        return hunger;
    }
 
    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
 
    public int getThirst() {
        return thirst;
    }
 
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }
 
    public int getInfection() {
        return infection;
    }
 
    public void setInfection(int infection) {
        this.infection = infection;
    }
 
    public String getMood() {
        return MoodArray.get(mood);
    }
 
    public void setMood(String mood) {
        this.mood = MoodArray.indexOf(mood);
    }
 
    public String getFace() {
    	if (health > 0)
    		if (infection > 0)
    			face = "@___@";
    		else
    			if (mood > 0)
    				if (mood < 4) {
    					if (mood==3)
    						face = "^___^";
    					if (mood==2)
    						face = "-___-";
    					if (mood==1)
    						face = ">___<";
    				}
    				else
    					face = "*___*";
    			else
    				face = "T___T";
    	else
    		face = "x___x";
    	return face;
    }
 
    public void setFace(String face) {
        this.face = face;
    }
}
