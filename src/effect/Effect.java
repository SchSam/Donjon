package effect;

import player.Player;


public abstract class Effect {
	
	protected int effectDuration;
	
	/**
	 * @return the name of the effect.
	 */
	public abstract String getName();
	
	
	/**
	 * Resolves the action of the effect on the player.
	 */
	public abstract void agit(Player player);
	
	/**
	 * @return the description of the effect
	 */
	public String getDescription(){
		return "*****************************";
	}
	
	/**
	 * 
	 * @return the number of turn the effect is active.
	 */
	public int getEffectDuration() {
		return effectDuration;
	}
	
}
