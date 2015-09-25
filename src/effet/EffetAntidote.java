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
		return "enleve les effet " + typeEffet.getName();
	}

	public static String getName(){
		return "antidote";
	}
}
