package effet;

import player.Player;

public abstract class Effet {
	
	protected int nbtime;
	
	public abstract String getName();
	
	public abstract void agit(Player player);
	
	public String getDescription(){
		return "*****************************";
	}
	
	public int getNbtime() {
		return nbtime;
	}
	
}
