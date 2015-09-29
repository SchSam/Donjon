package potion;

import effect.Effect;
import player.Player;

public class Potion {

	private Effect effect;
	private String name;
	
	public Potion(Effect effect,String name) {
		this.effect = effect;
		this.name = name;
	}
	
	/**
	 * 
	 * @return name of the potion
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return description of the potion
	 */
	public String getDescription() {
		return "potion who "+ effect.getDescription();
	}
	/**
	 * 
	 * @param add effect to the player
	 */
	public void proc(Player player) {
		player.addEffect(effect);
		player.removePotion(this);
	}

}
