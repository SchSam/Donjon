package furniture;

import dungeon.Dungeon;

public class Furniture {

	private String cmd;
	private String name;
	private String description;
	
	public Furniture(String cmd, String name, String description) {
		this.cmd = cmd;
		this.name = name;
		this.description = description;
	}

	/**
	 * @return list command with furniture
	 */
	public String getCmd() {
		return cmd;
	}
	
	/**
	 * @return name of furniture
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * function that manages interaction with the furniture
	 * @param dungeon
	 * @return interraction with furniture
	 */
	public String interact(Dungeon dungeon){
		return description;
	}
	
}
