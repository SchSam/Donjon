package effet;

import player.Player;

public class EffetPoison extends Effet {
	
	private int dmg;
	
	public static String getName(){
		return "Poison";
	}
	
	public EffetPoison(int dmg, int time) {
		nbtime=time;
		this.dmg = dmg;
	}

	@Override
	public void agit(Player player) {
		player.setLife(player.getLife()-dmg);
		nbtime--;
		if(nbtime<=0)
			player.removeEffet(this);
	}

	@Override
	public String getDescription() {
		return "fait perdre quelques points de vie a chaque changement de salle";
	}

}
