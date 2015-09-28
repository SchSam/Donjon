package dungeon;

import java.util.Random;

import furniture.Furniture;
import furniture.FurnitureFactory;

import room.Direction;
import room.Room;
import room.RoomFactory;

public class GeneratorDungeon {
	
	/**
	 * create a random room 
	 * @return room
	 */
	public static Room createRoom(){
		Room room=new Room();
		initFurnitures(room);
		initDoors(room);
		return room;
	}
	
	public static Room createRoom(Room oldroom){
		Room room=RoomFactory.getRoom(oldroom);
		initFurnitures(room);
		initDoors(room);
		return room;		
	}
	/** init furnitures in room
	 * 
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

	public static Room createRoom(Room oldroom, String direction) {
		if(Parametre.nbSalleVisite>=4 && new Random().nextInt(3)==0){
			System.out.println("Voici la sortie de cette etage.");
			return genereNewStage();
		}
		Parametre.nbSalleVisite++;
		Room room=createRoom(oldroom);
		room.setDoors(Direction.getContraire(direction), oldroom);
		return room;
	}

	public static Room genereNewStage() {
		Parametre.nbSalleVisite=1;
		Parametre.numEtage++;
		System.out.println("Vous etes maintenant aux "+Parametre.numEtage+" etage!");
		return createRoom();
	}
	
}
