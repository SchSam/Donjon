package Player;

import Monster.Monster;

public enum Weapon {
	
	shutgun("shutgun", 10, "mun shutgun", 15, "firearm");

	private String name;
	
	private int nbAmmo;
	private String typeAmmo;
	
	private int power;
	private String typeWeapon;
	
	Weapon(String name, int nbAmmo, String typeAmmo, int power,String typeWeapon) {
		this.name = name;
		this.nbAmmo = nbAmmo;
		this.typeAmmo = typeAmmo;
		this.power = power;
		this.typeWeapon = typeWeapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbAmmo() {
		return nbAmmo;
	}

	public void setNbAmmo(int nbAmmo) {
		this.nbAmmo = nbAmmo;
	}

	public String getTypeAmmo() {
		return typeAmmo;
	}

	public void setTypeAmmo(String typeAmmo) {
		this.typeAmmo = typeAmmo;
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

	public void setDistance(String typeWeapon) {
		this.typeWeapon = typeWeapon;
	}
	

	public String tire(Monster m){
		if(typeAmmo.equals("None")){
			return m.takeDommage(this);
		}else if(nbAmmo>0){
			nbAmmo--;
			return m.takeDommage(this);
		}
		return "votre "+name+" n'as plus de "+typeAmmo;
	}
	
}
