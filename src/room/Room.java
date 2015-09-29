package room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dungeon.Dungeon;
import dungeon.GeneratorDungeon;
import furniture.Furniture;
/**
 * simple room with door and furniture
 * @author scharre
 *
 */
public class Room {
	
	private Map<String,Room> doors= new HashMap<String,Room>();
	private Map<String,Furniture> furnitures= new HashMap<String,Furniture>();
	
	/**
	 * function that make the player enter in a room
	 * @param dungeon
	 * @return user message
	 */
	public String enterTheRoom(Dungeon dungeon) {
		System.out.println("you enter in a room\n");
		return getDescription();
	}
	
	/**
	 * 
	 * @return possible commands
	 */
	public ArrayList<String> getCommands(){
		
		ArrayList<String> cmds = new ArrayList<String>();
	
		for(String s : doors.keySet())
			cmds.add(s);
		
		for(String s : furnitures.keySet())
			cmds.add(s);
		
		return cmds;
		
	}
    /**
     * interpret the user command on the room
     * @param command
     * @param dungeon
     */
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
				System.out.println(furniture.interact(dungeon));
		}
	}
	/***
	 * add a door to the room
	 * @param direction (door)
	 * @param room
	 */
	public void setDoors(String s, Room room){
		doors.put(s, room);
	}
	
	public Map<String, Room> getDoors() {
		return doors;
	}
	/**
	 * add a furniture to the room
	 * @param action (cmd)
	 * @param furniture
	 */
	public void setFurnitures(String s,Furniture furniture){
		furnitures.put(s, furniture);
	}
	
	/**
	 * description of the room
	 * @return message
	 */
	public String getDescription(){
		
		String s="In this room there is " + doors.keySet().size()+" door(s).\n";
		
		for(String d : getCommands()){
			s+="> "+d+"\n";
		}
		
		return s;
		
	}
}
