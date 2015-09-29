package player;

import java.util.ArrayList;

import armor.Armor;

import effect.Effect;

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
	private ArrayList<Effect> effects=new ArrayList<Effect>();
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
	
	public String getEtat(){
		return life+"/"+maxlife;
	}
	/**
	 * 
	 * @return if the player is dead or not
	 */
	public boolean isDead(){
		return life<=0;
	}
	
	public Armor getArmor() {
		return armor;
	}
	
	public ArrayList<Weapon> getWeapons() {
		return weapons;
	}
	
	public ArrayList<Potion> getPotions() {
		return potions;
	}

	public ArrayList<Armor> getArmors() {
		return armors;
	}

	public ArrayList<Effect> getEffects() {
		return effects;
	}
	

	/**
	 * add potion to the player
	 * @param potion
	 */
	public void addPotion(Potion p) {
		System.out.println(p.getDescription());
		potions.add(p);
	}
	/**
	 * add weapon to the player
	 * @param weapon
	 */
	public void addWeapon(Weapon w) {
		System.out.println(w.getDescription());
		weapons.add(w);
	}
	/**
	 * add armor to the player
	 * @param armor
	 */
	public void addArmor(Armor a) {
		System.out.println("you have : \n"+a.getDescription());
		armors.add(a);
	}
	/**
	 * add effect to the player
	 * @param effect
	 */
	public void addEffect(Effect e) {
		System.out.println(e.getDescription());
		effects.add(e);
		// execute once after the add
		e.execute(this);
	}
	
	/**
	 * remove effect to the player
	 * @param effect
	 */
	public void removeEffect(Effect effect) {
		effects.remove(effect);
	}
	/**
	 * remove potion to the player
	 * @param potion
	 */
	public void removePotion(Potion potion) {
		potions.remove(potion);
	}
	
	/**
	 * remove effect of the type of the player
	 * @param typeEffect (class : Class<? extends Effect>) example : EffectPoison.class
	 */
	public void removeTypeEffect(Class<? extends Effect> typeEffect) {
		
		for(int i=effects.size()-1;i>=0;i--)
			if(typeEffect.isInstance(effects.get(i)))
				effects.remove(effects.get(i));
		
	}
	/**
	 * 
	 * @return description of the armors of the player
	 */
	public String getArmorDescription() {
		String s="My armors : \n";
		int i=0;
		for(Armor a:armors){
			i++;
			if(a.equals(armor)){
				s+=i+") (equip)"+a.getDescription()+"\n";
			}else{
				s+=i+") "+a.getDescription()+"\n";
			}
		}
		return s;
	}
	/**
	 * 
	 * @return description of the weapons of the player
	 */
	public String getWeaponsDescription() {
		String s="My weapons :  \n";
		int i=0;
		for(Weapon w:weapons){
			i++;
			s+=i+") "+w.getDescription()+"\n";
		}
		return s;
	}
	/**
	 * 
	 * @return description of the effects of the player
	 */
	public String getEffectDescription() {
		String s="My effects : \n";
		int i=0;
		for(Effect e:effects){
			i++;
			s+=i+") "+e.getDescription()+"\n";
		}
		return s;
		
	}
	/**
	 * 
	 * @return description of the potions of the player
	 */
	public String getPotionDescription() {
		String s="My potions : \n";
		int i=0;
		for(Potion p:potions){
			i++;
			s+=i+") "+p.getDescription()+"\n";
		}
		return s;
	}
	/**
	 * @param number
	 * @return weapon number w-1 in weapons (return punch if w=0)
	 */
	public Weapon getWeapons(int w) {
		if(weapons.size()<w || w<=0)
			return WeaponFactory.punch;
		return weapons.get(w-1);
	}
	/**
	 * equip armor number w in armors
	 * @param int number
	 * @return message if the armor was equiped or not (String)
	 */
	public String equip(int w) {
		if(armors.size()>w && w>=0){
			armor=armors.get(w);
			return "equip armor number "+(w+1);
		}else{
			return "no armor number "+(w+1);
		}
	}

	/**
	 * use potion number w in potions
	 * @param int number
	 * @return message if the potion was used or not (String)
	 */
	public String usePotion(int w) {
		if(potions.size()>w && w>=0){
			potions.get(w).proc(this);
			return "potion number "+(w+1)+" use";
		}else{
			return "no potion number "+(w+1);
		}
	}
	/**
	 * execute once all the effects of the player
	 */
	public void executeeffects() {
		for(int i=effects.size()-1;i>=0;i--)
			effects.get(i).execute(this);
	}
	
	/**
	 * damage received by the monster
	 * @param monster
	 */
	public void getDamage(Monster monster) {
		if(armor==null)
			life-=monster.getStrength();
		else
			life-=armor.getDamage(monster);
		
	}
}
