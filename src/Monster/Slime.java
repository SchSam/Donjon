package Monster;

import Player.Player;
import Player.Weapon;

public class Slime extends Monster {

	public Slime(String name,int life, int force) {
		super(name,life, force);
		typeMonster="slime";
	}
	
	@Override
	public String takeDommage(Weapon weapon) {
		if(weapon.getTypeWeapon().equals("coupant"))
			return "vous avez coupé le "+name+" en 2 mais il s'est reformé";
		
		return super.takeDommage(weapon);
		
	}

	@Override
	public String agit(Player player) {
		// TODO Auto-generated method stub
		return super.agit(player);
	}

}
