package effet;

import java.util.Random;

public class EffetFactory {

	public static Effet getEffet(int level) {
		int r=new Random().nextInt(3); 
		switch(r){
			case 0:
				return getEffetPoison(level);
			case 1:
				return getEffetAntidoteEffetPoison();
			case 2:
				return getEffetAntidoteEffet();
		}
		return null;
	}
	
	public static Effet getEffetPoison(int level) {
		return new EffetPoison(level,new Random().nextInt(4)+2);
	}
	
	public static Effet getEffetAntidoteEffetPoison() {
		return new EffetAntidote(EffetPoison.class);
	}

	public static Effet getEffetAntidoteEffet() {
		return new EffetAntidote(Effet.class);
	}
}
