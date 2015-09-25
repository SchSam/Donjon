package dungeon;
import java.util.Scanner;

import player.Player;


import room.Room;

public class Dungeon {
	
	
	private Room currentRoom;
	private final Scanner scanner = new Scanner(System.in);
	private Player player;

	public void initDungeon(){
		player=new Player(100);
		Parametre.numEtage=0;
		currentRoom = GeneratorDungeon.genereNewStage();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		player.agiteffets();
		this.currentRoom = currentRoom;
	}

	public boolean interpretCommand(String command) {
		switch(command){
			case"help":
				System.out.println(">description");
				System.out.println(">see weapons");
				System.out.println(">see armors");
				System.out.println(">see effets");
				System.out.println(">see potions");
				System.out.println(">use {num potions}");
				System.out.println(">equipe {num armors}");
				System.out.println(">state of health");
				return false;
			case"description":
				System.out.println(currentRoom.getDescription());
				return false;
			case"see weapons":
				player.getWeaponsDescription();
				return false;
			case"see armors":
				player.getArmorDescription();
				return false;
			case"see effets":
				player.getEffetDescription();
				return false;
			case"see potions":
				player.getPotionDescription();
				return false;
			case"state of health":
				System.out.println(player.getEtat());
				return false;
		}
		
		String[] cmd=command.split(" ");
		
		if(cmd.length==2 && cmd[0].equals("equipe")){
			
			try{
				int w=Integer.parseInt(cmd[1]);
				System.out.println(player.equipe(w-1));
			}catch(NumberFormatException e){
				System.out.println("equipe {num armor}");
			}
			
		}else if(cmd.length==2 && cmd[0].equals("use")){
			try{
				int p=Integer.parseInt(cmd[1]);
				System.out.println(player.usePotion(p-1));
			}catch(NumberFormatException e){
				System.out.println("equipe {num potion}");
			}
		}
		return currentRoom.interpretCommand(command, this);
	}

	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.start();
		
	}

	public void start() {
		initDungeon();
		String line ="";
		do {
			System.out.println(getCurrentRoom().getDescription());
			do{
				line = scanner.nextLine();
			}while(!interpretCommand(line));
			
		} while (!player.isDead());
	}

	public Player getPlayer() {
		return player;
	}
}