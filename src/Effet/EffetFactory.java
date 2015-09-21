package Effet;

import java.util.Random;

public class EffetFactory {

	public static Effet getEffet(int level) {
		int r=new Random().nextInt(2); 
		switch(r){
		case 0:
			return new Effet();
		case 1:
			return new Effet();
		}
		return null;
	}

}
