package room;

import java.util.ArrayList;

import dungeon.Dungeon;
/**
 * room with an enigma
 * @author scharre
 *
 */
public class RoomEnigma extends Room {
	
	private boolean enigmeSolved = false;
	private Enigma enigma;
	
	public RoomEnigma(Enigma enigma) {
		this.enigma=enigma;
	}
	
	@Override
	public String enterTheRoom(Dungeon dungeon) {
		if(enigmeSolved)
			return super.enterTheRoom(dungeon);
		
		String s="you enter in the room\n";
		s+="a wild genius appears\n";
		s+="hi i am lucas the genius\n";
		
		s+=enigma.getEnigma()+"\n";
		
		for(String c : enigma.getChoices()){
			s+="> "+c+"\n";
		}
		return s;
	}
	
	@Override
	public ArrayList<String> getCommands() {
		if(enigmeSolved)
			return super.getCommands();
		
		return enigma.getChoices();
	}

	@Override
	public void interpretCommand(String command, Dungeon dungeon) {
		if(enigmeSolved){
			super.interpretCommand(command, dungeon);
		}else{
			if(enigma.getChoices().contains(command)){
				if(enigma.userchoice(command)){
					enigmeSolved=true;
					System.out.println("good job!");
					enterTheRoom(dungeon);
				}else{
					System.out.println("FALSE !!!");
					dungeon.getPlayer().setLife(dungeon.getPlayer().getLife()-4);
				}
			}
		}
	}
}
