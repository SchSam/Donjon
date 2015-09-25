package armor;

import java.util.Random;

public class ArmorFactory {
	
	
	public static Armor getArmor(int level){
		
		int r=new Random().nextInt(2); 
		switch(r){
		case 0:
			return new Armor("iron armor",new Random().nextInt(level*3),Math.min(50,new Random().nextInt(level*3)));
		case 1:
			return new ArmorSlime("slime armor",new Random().nextInt(level*3),Math.min(50,new Random().nextInt(level*3)));
		}
		return null;
		
	}
	
}
