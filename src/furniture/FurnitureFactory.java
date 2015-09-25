package furniture;

import java.util.Random;

public class FurnitureFactory {
	

	public static Furniture getFurniture(){
		
		int r=new Random().nextInt(4); 
		switch(r){
			case 0:
				return new Wardrobe();
			case 1:
				return new Carpet();
			case 2:
				return new Furniture("look the picture","picture","it is very beautiful");
			case 3:
				return new Furniture("look the chandelier","chandelier","I'm gonna swing from the chandelier, from the chandelier");
		}
		return null;
	}
	
}
