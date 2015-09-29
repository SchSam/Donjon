package effect;

import java.util.Random;

/**
 * The EffectFactory class let the game generates different types of effects.
 * 
 * @author bricout
 *
 */
public class EffectFactory {
	
	/**
	 * Creates a random effect whose stats depends of the level specified.
	 * 
	 * @param level the level of the current dungeon.
	 *
	 * @return a randomly created effect.
	 */

	public static Effect getEffet(int level) {
		int r=new Random().nextInt(3); 
		switch(r){
			case 0:
				return getEffectPoison(level);
			case 1:
				return getEffectAntidoteEffectPoison();
			case 2:
				return getEffectAntidoteEffect();
		}
		return null;
	}
	/**
	 * @return Poison effect
	 */
	public static Effect getEffectPoison(int level) {
		return new EffectPoison(level,new Random().nextInt(4)+2);
	}
	
	/**
	 * @return effect antidote anti-poison
	 */
	public static Effect getEffectAntidoteEffectPoison() {
		return new EffectAntidote(EffectPoison.class);
	}

	/**
	 * @return effect antidote anti-effect
	 */
	public static Effect getEffectAntidoteEffect() {
		return new EffectAntidote(Effect.class);
	}
}
