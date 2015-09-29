package effet;

import player.Player;

public class EffetPoison extends Effet {
	
	public static String nameClass="poison";
	private int dmg;
	
	public String getName(){
		return "poison";
	}
	
	public EffetPoison() {
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
		return "fait perdre quelques points de vie a chaque changement de salle (tour "+getNbtime()+")";
	}

}
