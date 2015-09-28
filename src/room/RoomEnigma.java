package room;

import java.util.ArrayList;

import dungeon.Dungeon;

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
		
		String s="you enter in the room";
		s+="a wild genius appears";
		s+="hi i am lucas the genius";
		
		s+=enigma.getEnigma();
		
		for(String c : enigma.getChoices()){
			s+="> "+c;
		}
		return s;
	}
	
	@Override
	public ArrayList<String> getCommandes() {
		if(enigmeSolved)
			return super.getCommandes();
		
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
