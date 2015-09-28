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



	public String getCmd() {
		return cmd;
	}
	
	public String getName(){
		return name;
	}
	
	public String agit(Dungeon dungeon){
		return description;
	}
	
}
