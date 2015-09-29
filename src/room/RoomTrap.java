package room;

import dungeon.Dungeon;
/**
 * room with a trap that makes damage at the start
 * @author scharre
 *
 */
public class RoomTrap extends Room{
	
	private boolean trapActivated = true ;
	
	@Override
	public String enterTheRoom(Dungeon dungeon) {
		if(!trapActivated)
			return super.enterTheRoom(dungeon);
		
		trapActivated=false;
		System.out.println("you enter in a room");
		System.out.println("this is a trap");
		dungeon.getPlayer().setLife(dungeon.getPlayer().getLife() - 5);
		return this.getDescription();
	}

}
