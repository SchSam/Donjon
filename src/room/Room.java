package room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dungeon.Dungeon;
import dungeon.GeneratorDungeon;

public class Room {
	
	private Map<String,Room> doors= new HashMap<String,Room>();
	
	public ArrayList<String> getCommandes(){
		
		ArrayList<String> cmds = new ArrayList<String>();
	
		for(String s : doors.keySet())
			cmds.add(s);
		
		return cmds;
		
	}

	public boolean interpretCommand(String command, Dungeon dungeon) {
		if(doors.containsKey(command)){
			Room nextroom = doors.get(command);
			if(nextroom == null){
				dungeon.setCurrentRoom(GeneratorDungeon.createRoom(this,command));
				setDoors(command, dungeon.getCurrentRoom());
			}else{
				dungeon.setCurrentRoom(nextroom);
			}
			return true;
		}
		return false;
	}
	
	public void setDoors(String s, Room room){
		doors.put(s, room);
	}
	
	public String getDescription(){
		
		String s="Dans Cette salle il y a " + doors.keySet().size()+" portes.\n";
		
		for(String d : getCommandes()){
			s+="> "+d+"\n";
		}
		
		return s;
		
	}
}
