package room;

import java.util.ArrayList;
import java.util.Random;

import dungeon.Dungeon;

public class RoomwithArmoire extends Room{
	
	private boolean armoire=true;
	
	public ArrayList<String> getCommandes(){
		
		ArrayList<String> cmds = super.getCommandes();
		if(armoire)
			cmds.add("see into armoire");
		
		return cmds;
		
	}
	
	public boolean interpretCommand(String command, Dungeon dungeon) {
		if(command.equals("see into armoire")){
			int r=new Random().nextInt(5);
			// new door
			if(r==0){
				setDoors("passer par l'armoire", null);
				System.out.println("il y a une porte caché dans l'armoire");
			}else if(r==1){
				System.out.println("il y a rien du tout dans cette armoire");
			}else if(r==2){
				System.out.println("this is a trap");
			}else if(r==3){
				System.out.println("il y a un gun");
			}else if(r==4){
				System.out.println("il y a un monstre");
			}
			armoire=false;
		}
		return super.interpretCommand(command, dungeon);
	}
	
	public String getDescription(){
		
		String s="Cette salle possède une armoire.\n";
		
		s+=super.getDescription();
		
		return s;
		
	}

}
