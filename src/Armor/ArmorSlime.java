package Armor;

import Monster.Monster;

public class ArmorSlime extends Armor {
	
	public ArmorSlime(String name, int reductiondmg, double reductionPourcentDmg) {
		super(name, reductiondmg, reductionPourcentDmg);
	}

	public int getDommage(Monster monster) {
		if(monster.getTypeMonster().equals("slime")){
			return 0;
		}
		return super.getDommage(monster);
	}
	
	public String getDescription(){
		return "cette armure est insensible aux slimes \n"+super.getDescription();
	}
}
