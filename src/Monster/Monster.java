package Monster;

import Player.Player;
import Player.Weapon;

public abstract class Monster {
	
	protected int life;
	protected int force;
	protected int name;
	protected String typeMonster;
	
	
	public Monster(int life, int force, int name) {
		this.life = life;
		this.force = force;
		this.name = name;
	}
	
	public String takeDommage(Weapon weapon){
		life-=weapon.getPower();
		if(life<=0){
			return "le "+name+" est mort :'(";
		}
		
		if (weapon.getPower()/2>life)
			return "le "+ name + " a pris la sauce :)";
		else if (weapon.getPower()/4>life)
			return "le "+ name + " pris quelque degat :|";
		
		return "le "+ name + " a presque pas subit de degat :(";
	
	}
	
	public String agit(Player player){
		player.getDommage(this);
		return "le "+ name +" vous attaque";
	}
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	public String getTypeMonster() {
		return typeMonster;
	}
	
}
