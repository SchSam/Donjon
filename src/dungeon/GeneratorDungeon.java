package dungeon;

import java.util.Random;

import room.Direction;
import room.Room;
import room.RoomwithArmoire;

public class GeneratorDungeon {
	
	public static Room createRoom(){
		int r=new Random().nextInt(2);
		Room room;
		if(r==0){
			room=new RoomwithArmoire();
		}else{
		    room=new Room();
		}
		
		return initDoors(room);
	}
	
	public static Room createRoom(Room oldroom){
		int r=new Random().nextInt(2);
		Room room;
		if(r==0 && !(oldroom instanceof RoomwithArmoire)){
			room=new RoomwithArmoire();
		}else{
		    room=new Room();
		}
		
		return initDoors(room);
	}

	private static Room initDoors(Room room) {
		
		Random r = new Random();
		int nbdoor = r.nextInt(Direction.values().length-2)+2;
		
		for(int i = 0 ; i < nbdoor ;i++)
			room.setDoors(Direction.getDirection(r.nextInt(Direction.values().length)), null);
		
		return room;
	}

	public static Room createRoom(Room oldroom, String direction) {
		Parametre.nbSalleVisite++;
		Room room=createRoom(oldroom);
		room.setDoors(Direction.getContraire(direction), oldroom);
		return room;
	}
	
}