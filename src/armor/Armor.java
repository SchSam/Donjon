package armor;

import monster.Monster;

/**
 * An armor protects the player against a certain amount of damage when he is attacked by a monster. </br></br>
 * 
 * The armor has two kinds of damage reduction : </br>
 * 
 * 	- the flat damage reduction, which subtracts a certain amount to the total damage. </br>
 * 	- the percentage of damage reduction, which removes a percentage of the total damage. </br></br>
 * 
 * The armor applies the flat reduction and then the percentage reduction.
 * 
 * @author bricout
 *
 */
public class Armor {

	protected int damageReduction;
	
	protected double damagePercentReduction;
	
	protected String name;
	
	
	/**
	 * Creates a new armor for the player.
	 * 
	 * @param name the name of the armor.
	 * 
	 * @param damageReduction the flat damage reduction against the monsters.
	 * 
	 * @param damagePercentReduction the percentage of total damage reduction.
	 */
	public Armor(String name, int damageReduction, double damagePercentReduction) {
		this.damageReduction = damageReduction;
		this.damagePercentReduction = damagePercentReduction;
		this.name = name;
	}

	/**
	 * Returns the amount of damage taken by the armor.
	 * 
	 * @param monster the monster attacking.
	 * 
	 * @return the damage inflicted, after the reduction by the armor.
	 */
	public int getDamage(Monster monster) {
		double dmg = monster.getStrength();
		dmg -= damageReduction;
		dmg -= dmg*damagePercentReduction;
		
		if(dmg<0)
			return 0;
		
		return (int) dmg;
	}
	
	/**
	 * 
	 * @return the name of the armor.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a text describing the flat damage and percentage of damage reduction of the armor.
	 * 
	 * @return a string displaying the damage reduction of the armor.
	 */
	public String getDescription() {
		String s="reduced "+damageReduction+" dmg\n";
		s+="reduced "+(int)(damagePercentReduction*100)+"% dmg\n";
		return s;  
	}
}
