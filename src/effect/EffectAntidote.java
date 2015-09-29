package effect;

import player.Player;

public class EffectAntidote extends Effect {

	private Class<? extends Effect> typeEffect;
	
	public EffectAntidote(Class<? extends Effect> typeEffet) {
		this.typeEffect = typeEffet;
	}

	@Override
	public void execute(Player player) {
		player.removeTypeEffect(typeEffect);
		player.removeEffect(this);
	}

	@Override
	public String getDescription() {
		try{
			return "remove the effects " + typeEffect.newInstance().getName();
		}catch(Exception e){
			return "remove the effects";
		}
	}
	@Override
	public String getName(){
		return "antidote";
	}
}
