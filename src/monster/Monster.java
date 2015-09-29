package monster;

import player.Player;
import weapon.Weapon;

public class Monster {
	
	protected int life;
	protected int maxlife;
	protected int force;
	protected String name;
	protected String typeMonster;
	
	
	public Monster(String name,int life, int force) {
		this.life = life;
		this.maxlife = life;
		this.force = force;
		this.name = name;
		this.typeMonster = "None";
	}
	
	/**
	 * calculates the damages that the weapon inflicts to the monster
	 * @param weapon
	 * @return description of the impact of the blow on the monster
	 */
	public String takeDommage(Weapon weapon){
		
		String s=name + " take "+weapon.getPower()+" dmg !\n";
		
		life-=weapon.getPower();
		if(life<=0){
			return s+"le "+name+" est mort :'(";
		}
		
		if (weapon.getPower()*2>maxlife)
			return s+"le "+ name + " a pris la sauce :)";
		else if (weapon.getPower()*4>maxlife)
			return s+"le "+ name + " a pris quelque degat :|";
		
		return s+"le "+ name + " a presque pas subit de degat :(";
	
	}
	
	/**
	 * the monster action
	 * @param player
	 * @return description monster action
	 */
	
	public String agit(Player player){
		player.getDommage(this);
		return "le "+ name +" vous attaque";
	}
	
	public int getLife() {
		return life;
	}
	
	public int getForce() {
		return force;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTypeMonster() {
		return typeMonster;
	}

	/**
	 * @return 
	 */
	public String getEtat() {
		int e=life*3/maxlife;
		if(e>=2){
			return "le "+name+" est en plein forme";
		}else if(e==1){
			return "le "+name+" commence a faiblir";
		}
		return "le "+name+" est faible";
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
