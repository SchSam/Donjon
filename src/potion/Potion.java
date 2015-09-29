package potion;

import effet.Effet;
import player.Player;

public class Potion {

	private Effet effet;
	private String name;
	
	public Potion(Effet effet,String name) {
		this.effet = effet;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return "potion who "+ effet.getDescription();
	}

	public void agit(Player player) {
		player.addEffet(effet);
		player.removePotion(this);
	}

}
