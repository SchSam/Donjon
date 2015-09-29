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
	public void execute(Player player) {
		player.setLife(player.getLife()-dmg);
		effectDuration--;
		if(effectDuration<=0)
			player.removeEffect(this);
	}

	@Override
	public String getDescription() {
		return "make you lose few hp everytime you move to another room (tour "+getEffectDuration()+")";
	}

}
