package my.experiments.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;

import org.springframework.stereotype.Service;

@Service
public class petLife {
	private LiveMetrics state;
	private int hungerDelay;
	private int thirstDelay;
	private int moodDelay;
	private int worsDelay;
	private int regenDelay;
	private int sickDelay;
	private int foodVol;
	private int drinkVol;
	private int impresVol;
	private int drugToxic;
	
	private List<String> MoodArray = new ArrayList<String>();
	
	public petLife() {
		state = new LiveMetrics();
    	MoodArray.add("unhappy");
    	MoodArray.add("borring");
    	MoodArray.add("normal");
    	MoodArray.add("joyful");
    	MoodArray.add("happy");
    	
    	hungerDelay = (2 + (int)(3*Math.random()))*1000;
    	thirstDelay = (1 + (int)(2*Math.random()))*1000;
    	moodDelay = (5 + (int)(11*Math.random()))*1000;
    	worsDelay = (1 + (int)(3*Math.random()))*1000;
    	sickDelay = (1 + (int)(10*Math.random()))*10;
    	regenDelay = (1 + (int)(2*Math.random()))*1000;
    	

    	foodVol = (20 + (int)(31*Math.random()));
    	drinkVol = (30 + (int)(41*Math.random()));
    	impresVol = 2;
    	drugToxic = (int)(100*Math.random());
    	
		//Голод
		Thread needFood = new Thread(new Runnable() {
			public void run() {
				while (state.getHealth() > 0) {
	            	if (state.getHunger() < 100) {
	            		state.setHunger(state.getHunger() + 1);
	            	}
	            	if (state.getHunger() > 99) {
	            		state.setHealth(state.getHealth() - 1);
	            	}
	            	try {
	            		Thread.sleep(hungerDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
				System.out.println("needFood stoped.");
			}
		});
		//Жажда
		Thread needDrink = new Thread(new Runnable() {
			public void run() {
				while (state.getHealth() > 0) {
					if (state.getThirst() < 100) {
						state.setThirst(state.getThirst() + 1);
					}
	            	if (state.getThirst() > 99) {
	            		state.setHealth(state.getHealth() - 1);
	            	}
	            	try {
	            		Thread.sleep(thirstDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
				System.out.println("needDrink stoped.");
			}
		});
		//Настроение
		Thread needPlay = new Thread(new Runnable() {
			public void run() {
				while (state.getHealth() > 0) {
					if (MoodArray.indexOf(state.getMood()) > 0) {
						state.setMood(MoodArray.get(MoodArray.indexOf(state.getMood()) - 1));
					}
	            	try {
	            		Thread.sleep(moodDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
				System.out.println("needPlay stoped.");
			}
		});
		//Болезнь
		Thread infected = new Thread(new Runnable() {
			public void run() {
				while (state.getHealth() > 0) {
					if (state.getInfection() > 0) {
						state.setInfection(state.getInfection() + 1);
					}
					if (state.getInfection() > 99) {
						state.setHealth(0);
					}
	            	try {
	            		Thread.sleep(worsDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
				System.out.println("infected stoped.");
			}
		});
		//МожетБолезнь
		Thread mayinfected = new Thread(new Runnable() {
			public void run() {
				while (state.getHealth() > 0) {
					if (state.getInfection() < 1) {
						if (Math.random() < 1/(100 * Math.pow(10,MoodArray.indexOf(state.getMood()))))
						state.setInfection(1);
					}
	            	try {
	            		Thread.sleep(sickDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
				System.out.println("mayinfected stoped.");
			}
		});
		//Регенерация
		Thread regeneration = new Thread(new Runnable() {
			public void run() {
				while (state.getHealth() > 0) {
					state.setHealth(state.getHealth() - state.getInfection() / 10);
					if (state.getHealth() < 100 && state.getHealth() > 0 && state.getThirst() < 100 && state.getHunger() < 100) {
						state.setHealth(state.getHealth() + 1);
					}
	            	try {
	            		Thread.sleep(regenDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
				System.out.println("regeneration stoped.");
			}
		});
		System.out.printf("Starting with raise:\nHunger increase every %d sec, Thirst increase %d sec, Mood decrease every %d sec\nInfection increase every %d sec, Health regenerate every %d sec, Сhance to get sick every %.2f sec.\n",
				hungerDelay/1000,
				thirstDelay/1000,
				moodDelay/1000,
				worsDelay/1000,
				regenDelay/1000,
				(float)sickDelay/1000);
		System.out.printf("Others params:\nFoods volume %d%%, Drinks volume %d%%, Drugs toxic %d%%.\n",
				foodVol,
				drinkVol,
				drugToxic);
		needFood.start();
		needDrink.start();
		needPlay.start();
		infected.start();
		mayinfected.start();
		regeneration.start();
	}
	
	public LiveMetrics getState() {
		return state;
	}
	
	public boolean feed() {
		if (state.getHealth() < 1)
			return false;
		if (state.getHunger() > 0 && state.getInfection() == 0) {
			state.setHunger((state.getHunger() > foodVol ? state.getHunger() - foodVol : 0));
			return true;
		}
		return false;
	}
	
	public boolean give_drink() {
		if (state.getHealth() < 1)
			return false;
		if (state.getThirst() > 0) {
			int mod = (state.getInfection() > 0 ? 2 : 1);
			state.setThirst((state.getThirst() > drinkVol/mod ? state.getThirst() - drinkVol/mod : 0));
			return true;
		}
		return false;
	}

	public boolean play() {
		if (state.getHealth() < 1)
			return false;
		if (state.getInfection() < 30) {
			int mod = (state.getInfection() > 0 ? 1 : 0);
			if (MoodArray.indexOf(state.getMood()) < MoodArray.size() - 1 - impresVol + mod) {
				state.setMood(MoodArray.get(MoodArray.indexOf(state.getMood()) + impresVol - mod));
			} else {
				state.setMood("happy");
			}
			return true;
		}
		return false;
	}

	public boolean treat() {
		if (state.getHealth() < 1)
			return false;
		if (state.getInfection() > 0) {
			state.setInfection(0);
			return true;
		}
		else
			if (state.getHealth() > drugToxic)
				state.setHealth(state.getHealth() - drugToxic);
			else
				state.setHealth(0);
		return false;
	}

}
