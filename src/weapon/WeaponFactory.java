package weapon;

import java.util.Random;

public class WeaponFactory {
	
	public static Weapon punch=new Weapon("punch", 0, "None", 5, "punch");

	public static Weapon getWeapon(int level){
		
		int r=new Random().nextInt(4); 
		switch(r){
			case 0:
				return new Weapon("shotgun", new Random().nextInt(5)+2, "mun shotgun", level*10+new Random().nextInt(30), "firearm");
			case 1:
				return new Weapon("sword", 0, "None", level*5+new Random().nextInt(10), "coupant");
			case 2:
				return new Weapon("magnum", new Random().nextInt(10)+5, "35mm", level*5+new Random().nextInt(10), "firearm");
			case 3:
				return new Weapon("laser-saber", new Random().nextInt(10)+5, "batterie", level*7+new Random().nextInt(20), "coupant");
		}
		return null;
	}
	
}
