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
		GeneratorDungeon.numEtage=0;
		this.enterInRoom(GeneratorDungeon.genereNewStage());
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void enterInRoom(Room room) {
		player.agiteffets();
		this.currentRoom = room;
		System.out.println(currentRoom.enterTheRoom(this));
	}

	public void interpretCommand(String command) {
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
				return;
			case"description":
				System.out.println(currentRoom.getDescription());
				return;
			case"see weapons":
				System.out.println(player.getWeaponsDescription());
				return;
			case"see armors":
				System.out.println(player.getArmorDescription());
				return;
			case"see effets":
				System.out.println(player.getEffetDescription());
				return;
			case"see potions":
				System.out.println(player.getPotionDescription());
				return;
			case"state of health":
				System.out.println(player.getEtat());
				return;
		}
		
		String[] cmd=command.split(" ");
		
		if(cmd.length==2 && cmd[0].equals("equipe")){
			
			try{
				int w=Integer.parseInt(cmd[1]);
				if(w>0)
					System.out.println(player.equipe(w-1));
			}catch(NumberFormatException e){
				System.out.println("equipe {num armor}");
			}
			
		}else if(cmd.length==2 && cmd[0].equals("use")){
			try{
				int p=Integer.parseInt(cmd[1]);
				if(p>0)
					System.out.println(player.usePotion(p-1));
			}catch(NumberFormatException e){
				System.out.println("use {num potion}");
			}
		}else{
			currentRoom.interpretCommand(command, this);
		}
	}

	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon();
		dungeon.start();
		
	}

	public void start() {
		initDungeon();
		String line ="";
		do {
			line = scanner.nextLine();
			interpretCommand(line);
		} while (!player.isDead());
	}

	public Player getPlayer() {
		return player;
	}
}