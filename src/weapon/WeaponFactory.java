package weapon;

import java.util.Random;

/**
 * The WeaponFactory class let the game generates different types of weapons.
 * 
 * @author bricout
 *
 */

public class WeaponFactory {
	
	/**
	 * Creates a random weapon whose stats depends of the level specified.
	 * 
	 * @param level the level of the current dungeon.
	 *
	 * @return a randomly created weapon.
	 */
	
	public static Weapon punch=new Weapon("punch", 0, "None", 5, "punch");

	public static Weapon getWeapon(int level){
		
		int r=new Random().nextInt(4); 
		switch(r){
			case 0:
				return new Weapon("shotgun", new Random().nextInt(5)+2, "mun shotgun", level*10+new Random().nextInt(30), "firearm");
			case 1:
				return new Weapon("sword", 0, "None", level*5+new Random().nextInt(10), "cutting");
			case 2:
				return new Weapon("magnum", new Random().nextInt(10)+5, "35mm", level*5+new Random().nextInt(10), "firearm");
			case 3:
				return new Weapon("laser-saber", new Random().nextInt(10)+5, "battery", level*7+new Random().nextInt(20), "cutting");
		}
		return null;
	}
	
}
