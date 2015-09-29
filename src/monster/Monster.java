package monster;

import player.Player;
import weapon.Weapon;

public class Monster {
	
	protected int life;
	protected int maxlife;
	protected int strength;
	protected String name;
	protected String typeMonster;
	
	
	public Monster(String name,int life, int strength) {
		this.life = life;
		this.maxlife = life;
		this.strength = strength;
		this.name = name;
		this.typeMonster = "None";
	}
	
	/**
	 * calculates the damages that the weapon inflicts to the monster
	 * @param weapon
	 * @return description of the impact of the blow on the monster
	 */
	public String takeDamage(Weapon weapon){
		
		String s=name + " take "+weapon.getPower()+" dmg !\n";
		
		life-=weapon.getPower();
		if(life<=0){
			return s+"the "+name+" is dead :'(";
		}
		
		if (weapon.getPower()*2>maxlife)
			return s+"the "+ name + " got rekt :)";
		else if (weapon.getPower()*4>maxlife)
			return s+"the "+ name + " took few dammages :|";
		
		return s+"the "+ name + " almost took no dammage :(";
	
	}
	
	/**
	 * the monster makes his action (attack, wait...)
	 * @param player
	 * @return action's description
	 */
	
	public String action(Player player){
		player.getDamage(this);
		return "the "+ name +" attacks you";
	}
	
	public int getLife() {
		return life;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTypeMonster() {
		return typeMonster;
	}

	/**
	 * message that contains the state of the monster
	 * @return message
	 */
	public String getState() {
		int e=life*3/maxlife;
		if(e>=2){
			return "the "+name+" is in good shape";
		}else if(e==1){
			return "the "+name+" start being weak";
		}
		return "the "+name+" is weak";
	}

	/**
	 * @return if the monster is dead
	 */
	public boolean isDead() {
		return life<=0;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
}
