package monster;

import java.util.Random;

/**
 * The MonsterFactory class let the game generates different types of monsters.
 * 
 * @author bricout
 *
 */
public class MonsterFactory {

	/**
	 * Creates a random monster whose stats depends of the level specified.
	 * 
	 * @param level the level of the current dungeon.
	 *
	 * @return a randomly created monster.
	 */
	
	public static Monster getMonster(int level) {
		int r=new Random().nextInt(2); 
		switch(r){
			case 0:
				return new Monster("monster",level*5,level);
			case 1:
				return new Slime("slime",level*5,level);
		}
		return null;
	}
}
