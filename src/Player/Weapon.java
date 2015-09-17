package Player;

public class Weapon {

	private String name;
	
	private int nbAmmo;
	private String TypeAmmo;
	
	private int power;
	private int distance;
	
	public Weapon(String name, int nbAmmo, String typeAmmo, int power,int distance) {
		this.name = name;
		this.nbAmmo = nbAmmo;
		TypeAmmo = typeAmmo;
		this.power = power;
		this.distance = distance;
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
		return TypeAmmo;
	}

	public void setTypeAmmo(String typeAmmo) {
		TypeAmmo = typeAmmo;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
}
