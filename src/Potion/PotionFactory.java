package Potion;

import java.util.Random;

public class PotionFactory {

	public static Potion getPotion(int level) {
		int r=new Random().nextInt(2); 
		switch(r){
		case 0:
			return new Potion();
		case 1:
			return new Potion();
		}
		return null;
	}

}
