package effet;

import player.Player;

public class EffetAntidote extends Effet {

	private Class<? extends Effet> typeEffet;
	
	public EffetAntidote(Class<? extends Effet> typeEffet) {
		this.typeEffet = typeEffet;
	}

	@Override
	public void agit(Player player) {
		player.removeTypeEffet(typeEffet);
		player.removeEffet(this);
	}

	@Override
	public String getDescription() {
		try{
			return "enleve les effets " + typeEffet.newInstance().getName();
		}catch(Exception e){
			return "enleve les effets";
		}
	}

	public String getName(){
		return "antidote";
	}
}
