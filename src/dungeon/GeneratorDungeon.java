package dungeon;

import java.util.Random;

import furniture.Furniture;
import furniture.FurnitureFactory;

import room.Direction;
import room.Room;
import room.RoomFactory;

public class GeneratorDungeon {
	
	public static int nbVisitedRoom;
	public static int numFloor;

	/**
	 * create a random room 
	 * @return new room
	 */
	public static Room createRoom(){
		Room room=new Room();
		initFurnitures(room);
		initDoors(room);
		return room;
	}
	
	/**
	 * create a random room which consider the oldroom 
	 * @param oldroom
	 * @return new room
	 */
	public static Room createRoom(Room oldroom){
		Room room=RoomFactory.getRoom(oldroom);
		initFurnitures(room);
		initDoors(room);
		return room;		
	}
	
	/**
	 * init furnitures in room
	 * @param room
	 */
	private static void initFurnitures(Room room) {
		
		Random r = new Random();
		Furniture furniture = null;
		int nbfurniture = r.nextInt(Direction.values().length);
		
		for(int i = 0 ; i < nbfurniture ;i++){
			furniture=FurnitureFactory.getFurniture();
			room.setFurnitures(furniture.getCmd(), furniture);
		}
		
	}
	
	/** init doors in room
	 * 
	 * @param room
	 */
	private static void initDoors(Room room) {
		
		Random r = new Random();
		int nbdoor = r.nextInt(Direction.values().length-2)+2;
		
		// the room can genere 2 door equals 
		for(int i = 0 ; i < nbdoor ;i++)
			room.setDoors(Direction.getDirection(r.nextInt(Direction.values().length)), null);
		
		// 2 doors mini
		while(room.getDoors().size()<2)
			room.setDoors(Direction.getDirection(r.nextInt(Direction.values().length)), null);
		
	}

	/**
	 * create a room which consider the oldroom but with the direction we just came
	 * @param oldroom
	 * @param direction
	 * @return new room
	 */
	public static Room createRoom(Room oldroom, String direction) {
		if(nbVisitedRoom>=4 && new Random().nextInt(3)==0){
			System.out.println("Here is the exit of this current floor.");
			return generateNewStage();
		}
		nbVisitedRoom++;
		Room room=createRoom(oldroom);
		room.setDoors(Direction.getOpposite(direction), oldroom);
		return room;
	}

	/**
	 * function that makes you go to the next floor
	 * @return new room
	 */
	public static Room generateNewStage() {
		nbVisitedRoom=1;
		numFloor++;
		System.out.println("You are now at the floor number "+numFloor+" !");
		return createRoom();
	}
	
}
