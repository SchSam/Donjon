package room;

import java.util.Random;
/**
 * The RoomFactory class let the game generates different types of rooms.
 * 
 * @author bricout
 *
 */
public class RoomFactory {

	public static Room getRoom(Room oldRoom) {
		int r=new Random().nextInt(4); 
		switch(r){
			case 0:
				return new Room();
			case 1:
				if(oldRoom instanceof RoomTrap)
					return new Room();
				return new RoomTrap();
			case 2:
				if(oldRoom instanceof RoomMonster)
					return new Room();
				return new RoomMonster();
			case 3:
				if(oldRoom instanceof RoomEnigma)
					return new Room();
				
				return new RoomEnigma(EgnimaFactory.getEgnima());
		}
		return null ;
	}

}
