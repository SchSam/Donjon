package potion;

import effect.Effect;
import player.Player;

public class Potion {

	private Effect effet;
	private String name;
	
	public Potion(Effect effet,String name) {
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
