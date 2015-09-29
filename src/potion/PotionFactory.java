package potion;

import java.util.Random;

import effect.EffectFactory;
/**
 * The PotionFactory class let the game generates different types of potions.
 * 
 * @author bricout
 *
 */

public class PotionFactory {
	
	/**
	 * Creates a random potion whose stats depends of the level specified.
	 * 
	 * @param level the level of the current dungeon.
	 *
	 * @return a randomly created potion.
	 */
	public static Potion getPotion(int level) {
		int r=new Random().nextInt(3); 
		switch(r){
			case 0:
				return new Potion(EffectFactory.getEffectPoison(level),"poison");
			case 1:
				return new Potion(EffectFactory.getEffectAntidoteEffectPoison(),"antidote");
			case 2:
				return new Potion(EffectFactory.getEffectAntidoteEffect(),"antidote");
		}
		return null;
	}

}
