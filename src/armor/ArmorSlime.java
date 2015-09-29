package armor;

import monster.Monster;

/**
 * The SlimeArmor protects the player against all damage if the monster attacking is a slime.
 * Otherwise, it acts like a normal armor and removes a portion of the monster's damage.
 * 
 * 
 * @author bricout
 *
 */
public class ArmorSlime extends Armor {
	
	/**
	 * Creates a new slime armor.
	 * 
	 * @see Armor
	 * 
	 * @param name
	 * @param reductiondmg
	 * @param reductionPourcentDmg
	 */
	public ArmorSlime(String name, int reductiondmg, double reductionPourcentDmg) {
		super(name, reductiondmg, reductionPourcentDmg);
	}

	@Override
	public int getDamage(Monster monster) {
		if(monster.getTypeMonster().equals("slime")){
			return 0;
		}
		return super.getDamage(monster);
	}
	
	@Override
	public String getDescription(){
		return "cette armure est insensible aux slimes\n"+super.getDescription();
	}
}
