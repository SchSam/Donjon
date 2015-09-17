package Player;

import java.util.ArrayList;

import Armor.Armor;
import Monster.Monster;

public class Player {

	private int life;
	private Armor armor;
	private ArrayList<Armor> armors=new ArrayList<Armor>();
	private ArrayList<Weapon> weapons=new ArrayList<Weapon>();
	private ArrayList<Effet> effets=new ArrayList<Effet>();
	private ArrayList<Potion> potions=new ArrayList<Potion>();
	
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public Armor getArmor() {
		return armor;
	}
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public ArrayList<Effet> getEffets() {
		return effets;
	}
	public ArrayList<Potion> getPotions() {
		return potions;
	}
	
	public ArrayList<Armor> getArmors() {
		return armors;
	}
	
	public void getDommage(Monster monster) {
		if(armor!=null)
			life-=monster.getForce();
		else
			life-=armor.getDommage(monster);
		
	}
	
	public boolean isDead(){
		return life<=0;
	}
	
	
}
