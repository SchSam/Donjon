package Player;

import java.util.ArrayList;

import Armor.Armor;
import Effet.Effet;
import Monster.Monster;
import Potion.Potion;

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
	public void addWeapon(Weapon w) {
		weapons.add(w);
	}
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public ArrayList<Effet> getEffets() {
		return effets;
	}
	public void addEffet(Effet e) {
		effets.add(e);
	}

	public ArrayList<Potion> getPotions() {
		return potions;
	}
	public void addPotion(Potion p) {
		potions.add(p);
	}

	public ArrayList<Armor> getArmors() {
		return armors;
	}
	
	public void addArmor(Armor a) {
		armors.add(a);
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
	public void getWeaponsDescription() {
		System.out.println("voici mes armes : ");
		int i=0;
		for(Weapon w:weapons){
			i++;
			System.out.println(i+") "+w.getDescription());
		}
		
	}
	
	public void getEffetDescription() {
		System.out.println("voici mes effet : ");
		int i=0;
		for(Effet e:effets){
			i++;
			System.out.println(i+") "+e.getDescription());
		}
		
	}
	
	public void getPotionDescription() {
		System.out.println("voici mes Potions : ");
		int i=0;
		for(Potion p:potions){
			i++;
			System.out.println(i+") "+p.getDescription());
		}
		
	}
	
	public void getArmorDescription() {
		System.out.println("voici mes Armors : ");
		int i=0;
		for(Armor a:armors){
			i++;
			if(a.equals(armor)){
				System.out.println(i+") (equipe)"+a.getDescription());
			}
			System.out.println(i+") "+a.getDescription());
		}
	}

	
}
