package room;

import java.util.ArrayList;
import java.util.Random;

import dungeon.Dungeon;

public class RoomwithArmoire extends Room{
	
	private boolean armoire=true;
	
	public ArrayList<String> getCommandes(){
		
		ArrayList<String> cmds = super.getCommandes();
		if(armoire)
			cmds.add("look into wardrobe");
		
		return cmds;
		
	}
	
	public boolean interpretCommand(String command, Dungeon dungeon) {
		if(command.equals("look into wardrobe")){
			int r=new Random().nextInt(5);
			// new door
			if(r==0){
				setDoors("passer par l'armoire", null);
				System.out.println("There is a hidden door in this wardrobe.");
			}else if(r==1){
				System.out.println("It's empty.");
			}else if(r==2){
				System.out.println("It is a trap !");
			}else if(r==3){
				System.out.println("There is a pistol in this wardrobe.");
			}else if(r==4){
				System.out.println("There is a monster in this wardrobe !");
			}
			armoire=false;
		}
		return super.interpretCommand(command, dungeon);
	}
	
	public String getDescription(){
		
		String s="There is a wardrobe in this room.\n";
		
		s+=super.getDescription();
		
		return s;
		
	}

}
