package effect;

import player.Player;

public class EffectPoison extends Effect {
	
	private int dmg;
	
	public EffectPoison() {	}
	
	public EffectPoison(int dmg, int time) {
		effectDuration=time;
		this.dmg = dmg;
	}
	
	
	@Override
	public String getName(){
		return "poison";
	}
	
	@Override
	public void agit(Player player) {
		player.setLife(player.getLife()-dmg);
		effectDuration--;
		if(effectDuration<=0)
			player.removeEffect(this);
	}

	@Override
	public String getDescription() {
		return "fait perdre quelques points de vie a chaque changement de salle (tour "+getEffectDuration()+")";
	}

}
