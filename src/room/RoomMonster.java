package room;

import monster.Monster;
import monster.MonsterFactory;
import dungeon.Dungeon;
import dungeon.Fight;
import dungeon.Parametre;

public class RoomMonster extends Room{
	
	private boolean monsterDead=false; 

	public String enterTheRoom(Dungeon dungeon) {
		if(monsterDead)
			return super.enterTheRoom(dungeon);
		
		System.out.println("you enter in a room\n");
		Monster monster=MonsterFactory.getMonster(Parametre.numEtage);
		new Fight(dungeon.getPlayer(),monster).start();
		monsterDead=true;
		return getDescription();
	}
}
