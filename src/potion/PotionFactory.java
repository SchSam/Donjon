package potion;

import java.util.Random;

import effet.EffetFactory;


public class PotionFactory {

	public static Potion getPotion(int level) {
		int r=new Random().nextInt(3); 
		switch(r){
			case 0:
				return new Potion(EffetFactory.getEffetPoison(level),"poison");
			case 1:
				return new Potion(EffetFactory.getEffetAntidoteEffetPoison(),"antidote");
			case 2:
				return new Potion(EffetFactory.getEffetAntidoteEffet(),"antidote");
		}
		return null;
	}

}
