import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import my.experiments.services.LiveMetrics;
import my.experiments.services.MyPetSOAPService;
import my.experiments.services.MyPetSOAPServiceService;


public class client {
	
	/*public static void main(String[] args) throws InterruptedException {
		MyPetSOAPServiceService service = new MyPetSOAPServiceService();
		MyPetSOAPService client = service.getMyPetSOAPServicePort();
		String say = "";
		LiveMetrics pet = client.feel();
		boolean dead = false;
		do {
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			if (pet.getHealth()<1) {
				System.out.printf("            ^     ^\n           = %s =   I'm %s... why? Why? WHY?!!\n\n", pet.getFace(), "dead");
				dead = true;
			}
			else
				System.out.printf("            ^     ^\n           = %s =  < %s. I'm %s!\n\n", pet.getFace(), say, pet.getMood());
			System.out.printf("\n Здоровьe: %3d%%          Голод: %3d%%\n[%s%s]  [%s%s]"
					,pet.getHealth()
					,pet.getHunger()
					, "П".repeat(pet.getHealth()/5)
					, "_".repeat(20 - pet.getHealth()/5)
					, "П".repeat(pet.getHunger()/5)
					, "_".repeat(20 - pet.getHunger()/5));
			System.out.printf("\n Инфекция: %3d%%          Жажда: %3d%%\n[%s%s]  [%s%s]"
					,pet.getInfection()
					,pet.getThirst()
					, "П".repeat(pet.getInfection()/5)
					, "_".repeat(20 - pet.getInfection()/5)
					, "П".repeat(pet.getThirst()/5)
					, "_".repeat(20 - pet.getThirst()/5));
			Thread.sleep(100);
			pet = client.feel();
			if (pet.getHunger() > 90)
				client.feed();
			if (pet.getThirst() > 90)
				client.giveDrink();
			if (pet.getMood().equals("unhappy"))
				client.play();
			if (pet.getInfection()>30)
				client.treat();
		} while (pet.getHealth() > 0 || !dead);
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		List<String> MoodArray = new ArrayList<String>();
		MoodArray.add("unhappy");
		MoodArray.add("borring");
		MoodArray.add("normal");
		MoodArray.add("joyful");
		MoodArray.add("happy");
		LiveMetrics pet = null;
		int hungerDelay = 0;
		int thirstDelay = 0;
		int moodDelay = 0;
		int shunger = 0;
		int sthirst = 0;
		int smood = 0;
		Date hStart = null;
		Date tStart = null;
		Date mStart = null;
		int foodVol = -10;
		int drinkVol = -10;
		int playVol = -1;
		int foodCor= 0;
		int drinkCor = 0;
		int playCor = 0;
		MyPetSOAPServiceService service = new MyPetSOAPServiceService();
		MyPetSOAPService client = service.getMyPetSOAPServicePort();
		System.out.println("Analize...");
		client.play();
		client.feed();
		client.giveDrink();
		client.play();
		client.feed();
		client.giveDrink();
		client.play();
		client.feed();
		client.giveDrink();
		client.play();
		client.feed();
		client.giveDrink();
		pet = client.feel();
		//наблюдаем до начала изменения 
		do {
			Date ct = new Date();
			LiveMetrics newMet = client.feel();
			if (newMet.getHealth() < 1)
				break;
			if (hStart == null && pet.getHunger() < newMet.getHunger()) {
				hStart = ct;
				shunger = newMet.getHunger();
			}
			if (tStart == null && pet.getThirst() < newMet.getThirst()) {
				tStart = ct;
				sthirst = newMet.getThirst();
			}
			if (mStart == null && !pet.getMood().equals(newMet.getMood())) {
				mStart = ct;
				smood = MoodArray.indexOf(newMet.getMood());
			}
			if (hStart != null && hungerDelay == 0 && newMet.getHunger() - shunger == 5)
				hungerDelay = (int)((ct.getTime() - hStart.getTime()) / 5000);
			if (tStart != null && thirstDelay == 0 && newMet.getThirst() - sthirst == 5)
				thirstDelay = (int)((ct.getTime() - tStart.getTime()) / 5000);
			if (mStart != null && moodDelay == 0 && smood - MoodArray.indexOf(newMet.getMood()) == 2)
				moodDelay = (int)((ct.getTime() - mStart.getTime()) / 2000);
		} while (hungerDelay == 0 || thirstDelay == 0 || moodDelay == 0);
		boolean dead = false;
		String say = "";
		do {
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.printf("HD: %d, TD: %d, MD: %d, FV: %d, DV: %d, PV: %d.\n", hungerDelay, thirstDelay, moodDelay, foodVol, drinkVol, playVol);
			System.out.println((foodCor != 0 ? "FC=" + foodCor + " " : "") + (drinkCor != 0 ? "DC=" + drinkCor + " " : "") + (playCor != 0 ? "PC=" + playCor + " " : ""));
			if (pet.getHealth()<1) {
				System.out.printf("            ^     ^\n           = %s =   I'm %s... why? Why? WHY?!!\n\n", pet.getFace(), "dead");
				dead = true;
			}
			else
				System.out.printf("            ^     ^\n           = %s =  < %s. I'm %s!\n\n", pet.getFace(), say, pet.getMood());
			System.out.printf("\n Здоровьe: %3d%%          Голод: %3d%%\n[%s%s]  [%s%s]"
					,pet.getHealth()
					,pet.getHunger()
					, "П".repeat(pet.getHealth()/5)
					, "_".repeat(20 - pet.getHealth()/5)
					, "П".repeat(pet.getHunger()/5)
					, "_".repeat(20 - pet.getHunger()/5));
			System.out.printf("\n Инфекция: %3d%%          Жажда: %3d%%\n[%s%s]  [%s%s]"
					,pet.getInfection()
					,pet.getThirst()
					, "П".repeat(pet.getInfection()/5)
					, "_".repeat(20 - pet.getInfection()/5)
					, "П".repeat(pet.getThirst()/5)
					, "_".repeat(20 - pet.getThirst()/5));
			if (pet.getInfection()>0)
				client.treat();
			Thread.sleep(100);
			if ((new Date()).getTime() >= hStart.getTime() + (Math.abs(foodVol) - foodCor) * hungerDelay * 1000) {
				hStart.setTime(hStart.getTime() + (Math.abs(foodVol) - foodCor) * hungerDelay * 1000);
				foodCor = 0;
				say = client.feed();
				pet = client.feel();
				if (foodVol <= 0 && pet.getHunger() > 1)
					foodVol = Math.abs(foodVol) - pet.getHunger();
				if (foodVol <= 0 && pet.getHunger() <= 1)
					foodVol -= 5;
				if (foodVol > 0 && pet.getHunger() > 1)
					foodCor = pet.getHunger();
			}
			if ((new Date()).getTime() >= tStart.getTime() + (Math.abs(drinkVol) - drinkCor) * thirstDelay * 1000) {
				tStart.setTime(tStart.getTime() + (Math.abs(drinkVol) - drinkCor) * thirstDelay * 1000);
				drinkCor = 0;
				say = client.giveDrink();
				pet = client.feel();
				if (drinkVol <= 0 && pet.getThirst() > 1)
					drinkVol = Math.abs(drinkVol) - pet.getThirst();
				if (drinkVol <= 0 && pet.getThirst() <= 1)
					drinkVol -= 5;
				if (drinkVol > 0 && pet.getThirst() > 1)
					drinkCor = pet.getThirst();
			}
			if ((new Date()).getTime() >= mStart.getTime() + (Math.abs(playVol) - playCor) * moodDelay * 1000) {
				mStart.setTime(mStart.getTime() + (Math.abs(playVol) - playCor) * moodDelay * 1000);
				playCor = 0;
				say = client.play();
				pet = client.feel();
				if (playVol <= 0 && MoodArray.indexOf(pet.getMood()) < 4)
					playVol = Math.abs(playVol) - 4 + MoodArray.indexOf(pet.getMood());
				if (playVol <= 0 && pet.getMood().equals("happy"))
					playVol--;
				if (playVol > 0 && MoodArray.indexOf(pet.getMood()) < 4)
					playCor = 4 - MoodArray.indexOf(pet.getMood());
			}
			pet = client.feel();
		} while (pet.getHealth() > 0 || !dead);
	}
}
