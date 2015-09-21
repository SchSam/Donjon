package Monster;

import java.util.Random;

public class MonsterFactory {

	public static Monster getEffet(int level) {
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
