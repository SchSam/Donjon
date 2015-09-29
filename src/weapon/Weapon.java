package weapon;

import monster.Monster;
/**
 * this is a weapon
 * @author scharre
 *
 */
public class Weapon {

	private String name;
	
	private int nbAmmo;
	private String typeAmmo;
	
	private int power;
	private String typeWeapon;
	
	public Weapon(String name, int nbAmmo, String typeAmmo, int power,String typeWeapon) {
		this.name = name;
		this.nbAmmo = nbAmmo;
		this.typeAmmo = typeAmmo;
		this.power = power;
		this.typeWeapon = typeWeapon;
	}

	public String getName() {
		return name;
	}

	public int getNbAmmo() {
		return nbAmmo;
	}

	public String getTypeAmmo() {
		return typeAmmo;
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	public String getTypeWeapon() {
		return typeWeapon;
	}

	/**
	 * check the ammos and attacks the monster
	 * @param monster
	 * @return message
	 */
	public String attack(Monster m){
		if(typeAmmo.equals("None")){
			return m.takeDamage(this);
		}else if(nbAmmo>0){
			nbAmmo--;
			return m.takeDamage(this);
		}
		return "your "+name+" has no "+typeAmmo+" left";
	}

	/**
	 * 
	 * @return description of the weapon
	 */
	public String getDescription() {
		String s="name : "+ name + "\n";
		if(!typeAmmo.equals("None")){
			s+="nb ammo : " + nbAmmo + "\ntype ammo : " + typeAmmo + "\n";
		}
		s+="power : " + power + "\ntypeWeapon : " + typeWeapon+"\n";
		return s;
	}
	
}
