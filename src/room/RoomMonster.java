package room;

import monster.Monster;
import monster.MonsterFactory;
import dungeon.Dungeon;
import dungeon.Fight;
import dungeon.GeneratorDungeon;
/**
 * room with a fight
 * @author scharre
 *
 */
public class RoomMonster extends Room{
	
	private boolean monsterDead=false; 
	
	@Override
	public String enterTheRoom(Dungeon dungeon) {
		if(monsterDead)
			return super.enterTheRoom(dungeon);
		
		System.out.println("you enter in a room\n");
		Monster monster=MonsterFactory.getMonster(GeneratorDungeon.numFloor);
		new Fight(dungeon.getPlayer(),monster).start();
		monsterDead=true;
		return getDescription();
	}
}
