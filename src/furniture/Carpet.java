package furniture;

import java.util.Random;

import dungeon.Dungeon;
import dungeon.Parametre;

public class Carpet extends Furniture {

	private boolean isOpen;
	
	public Carpet() {
		super("look under carpet", "carpet", "this is a carpet");
		isOpen=false;
	}
	
	public Carpet(boolean isOpen) {
		super("look under carpet", "carpet", "this is a carpet");
		this.isOpen=isOpen;
	}

	public String agit(Dungeon dungeon){
		if(isOpen)
			return super.agit(dungeon);
		
		String s="";
		Random r=new Random();
		int x=r.nextInt(3);
		switch(x){
			case 0:
				dungeon.getCurrentRoom().setDoors("go to the hatch under Carpet", null);
				s="There is a hidden door under this carpet";
				break;
			case 1:
				s="there is nothing under this carpet";
				break;
			case 2:
				s="It is a trap !";
				dungeon.getPlayer().setLife(dungeon.getPlayer().getLife()-r.nextInt(Parametre.numEtage*3));
				break;
		}
		isOpen=true;
		return s;
	}
	
}
