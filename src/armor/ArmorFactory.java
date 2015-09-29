package armor;

import java.util.Random;

/**
 * The ArmorFactory class let the game generates different types of armors.
 * 
 * @author bricout
 *
 */
public class ArmorFactory {
	
	/**
	 * Creates a random armor whose stats depends of the level specified.
	 * 
	 * @param level the level of the current dungeon.
	 *
	 * @return a randomly created armor.
	 */
	public static Armor getArmor(int level){
		
		int r=new Random().nextInt(2); 
		switch(r){
		case 0:
			return new Armor("iron armor",new Random().nextInt(level*3),Math.min(50,new Random().nextInt(level*3)/100.0));
		case 1:
			return new ArmorSlime("slime armor",new Random().nextInt(level*3),Math.min(50,new Random().nextInt(level*3)/100.0));
		}
		return null;
		
	}
	
}
