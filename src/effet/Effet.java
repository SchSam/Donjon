package effet;

import player.Player;

public abstract class Effet {

	protected int nbtime;
	
	public static String getName(){
		return "******";
	}
	
	public abstract void agit(Player player);
	
	public String getDescription(){
		return "*****************************";
	}
	
	public int getNbtime() {
		return nbtime;
	}
	
}
