package player;

import java.util.ArrayList;

import armor.Armor;

import effet.Effet;

import monster.Monster;

import potion.Potion;
import weapon.Weapon;
import weapon.WeaponFactory;


public class Player {

	private int life;
	private int maxlife;
	private Armor armor;
	private ArrayList<Armor> armors=new ArrayList<Armor>();
	private ArrayList<Weapon> weapons=new ArrayList<Weapon>();
	private ArrayList<Effet> effets=new ArrayList<Effet>();
	private ArrayList<Potion> potions=new ArrayList<Potion>();
	
	public Player(int life) {
		this.maxlife=life;
		this.life=life;
	}
	
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
		System.out.println(w.getDescription());
		weapons.add(w);
	}
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	public Weapon getWeapons(int w) {
		if(weapons.size()<w || w>=0)
			return WeaponFactory.punch;
		return weapons.get(w-1);
	}
	public ArrayList<Effet> getEffets() {
		return effets;
	}
	public void addEffet(Effet e) {
		System.out.println(e.getDescription());
		effets.add(e);
		// agit une premiere fois a l'ajout
		e.agit(this);
	}
	
	public void agiteffets() {
		for(int i=effets.size()-1;i>=0;i--)
			effets.get(i).agit(this);
	}
	
	public void removeEffet(Effet effet) {
		effets.remove(effet);
	}
	
	public void removePotion(Potion potion) {
		potions.remove(potion);
	}
	

	public void removeTypeEffet(Class<? extends Effet> typeEffet) {
		
		for(int i=effets.size()-1;i>=0;i--)
			if(typeEffet.isInstance(effets.get(i)))
				effets.remove(effets.get(i));
		
	}
	
	public void actionEffet(){
		
		for(int i=effets.size()-1;i>=0;i--)
			effets.get(i).agit(this);
		
	}
	
	public ArrayList<Potion> getPotions() {
		return potions;
	}
	public void addPotion(Potion p) {
		System.out.println(p.getDescription());
		potions.add(p);
	}

	public ArrayList<Armor> getArmors() {
		return armors;
	}
	
	public void addArmor(Armor a) {
		System.out.println(a.getDescription());
		armors.add(a);
	}
	public void getDommage(Monster monster) {
		if(armor==null)
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
			}else{
				System.out.println(i+") "+a.getDescription());
			}
		}
	}
	public int getMaxlife() {
		return maxlife;
	}
	public void setMaxlife(int maxlife) {
		this.maxlife = maxlife;
	}
	
	public String getEtat(){
		return life+"/"+maxlife;
	}

	public String equipe(int w) {
		if(weapons.size()>=w && w>=0){
			armor=armors.get(w);
			return "equipe armor n°"+(w);
		}else{
			return "no armor n°"+(w);
		}
	}

	public String usePotion(int w) {
		if(potions.size()>=w && w>=0){
			potions.get(w).agit(this);
			return "potion n°"+(w)+" use";
		}else{
			return "no potion n°"+(w);
		}
	}

	
	
}
