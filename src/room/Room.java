package room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dungeon.Dungeon;
import dungeon.GeneratorDungeon;
import furniture.Furniture;

public class Room {
	
	private Map<String,Room> doors= new HashMap<String,Room>();
	private Map<String,Furniture> furnitures= new HashMap<String,Furniture>();
	
	public String enterTheRoom(Dungeon dungeon) {
		System.out.println("you enter in a room\n");
		return getDescription();
	}
	
	public ArrayList<String> getCommandes(){
		
		ArrayList<String> cmds = new ArrayList<String>();
	
		for(String s : doors.keySet())
			cmds.add(s);
		
		for(String s : furnitures.keySet())
			cmds.add(s);
		
		return cmds;
		
	}

	public void interpretCommand(String command, Dungeon dungeon) {
		if(doors.containsKey(command)){
			Room nextroom = doors.get(command);
			if(nextroom == null){
				dungeon.enterInRoom(GeneratorDungeon.createRoom(this,command));
				setDoors(command, dungeon.getCurrentRoom());
			}else{
				dungeon.enterInRoom(nextroom);
			}
		}else if(furnitures.containsKey(command)){
			Furniture furniture = furnitures.get(command);
			if(furniture != null)
				System.out.println(furniture.agit(dungeon));
		}
	}
	
	public void setDoors(String s, Room room){
		doors.put(s, room);
	}
	
	public Map<String, Room> getDoors() {
		return doors;
	}
	
	public void setFurnitures(String s,Furniture furniture){
		furnitures.put(s, furniture);
	}
	
	public String getDescription(){
		
		String s="Dans Cette salle il y a " + doors.keySet().size()+" portes.\n";
		
		for(String d : getCommandes()){
			s+="> "+d+"\n";
		}
		
		return s;
		
	}
}
