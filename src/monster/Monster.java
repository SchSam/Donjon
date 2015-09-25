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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTypeMonster() {
		return typeMonster;
	}

	public String getEtat() {
		int e=life*3/maxlife;
		if(e>=2){
			return "le "+name+" est en plein forme";
		}else if(e==1){
			return "le "+name+" est commence a faiblir";
		}
		return "le "+name+" est faible";
	}

	public boolean isDead() {
		return life<=0;
	}
	
}
