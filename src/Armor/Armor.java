package Armor;

import Monster.Monster;

public class Armor {

	protected int reductiondmg;
	protected double reductionPourcentDmg;
	protected String name;
	
	
	public Armor(String name, int reductiondmg, double reductionPourcentDmg) {
		this.reductiondmg = reductiondmg;
		this.reductionPourcentDmg = reductionPourcentDmg;
		this.name = name;
	}

	public int getDommage(Monster monster) {
		double dmg = monster.getForce();
		dmg = dmg - reductiondmg;
		dmg = dmg - dmg*reductionPourcentDmg;
		
		
		if(dmg<0)
			return 0;
		
		return (int) dmg;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		String s="reduit "+reductiondmg+" dmg\n";
		s+="reduit "+reductionPourcentDmg+"% dmg\n";
		return s;  
	}
}
