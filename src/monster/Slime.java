package monster;

import player.Player;
import weapon.Weapon;

public class Slime extends Monster {

	public Slime(String name,int life, int force) {
		super(name,life, force);
		typeMonster="slime";
	}
	
	@Override
	public String takeDamage(Weapon weapon) {
		if(weapon.getTypeWeapon().equals("cutting"))
			return "you have slain "+name+" but he merges";
		
		return super.takeDamage(weapon);
		
	}

	@Override
	public String action(Player player) {
		return super.action(player);
	}

}
