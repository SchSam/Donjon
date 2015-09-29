package dungeon;
import java.util.Scanner;

import player.Player;


import room.Room;

public class Dungeon {
	
	
	private Room currentRoom;
	private final Scanner scanner = new Scanner(System.in);
	private Player player;

	/**
	 * Initializing the dungeon
	 */
	public void initDungeon(){
		player=new Player(100);
		GeneratorDungeon.numFloor=0;
		this.enterInRoom(GeneratorDungeon.generateNewStage());
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	/**
	 * function that makes the player enter in a room
	 * @param room
	 */
	public void enterInRoom(Room room) {
		player.executeeffects();
		this.currentRoom = room;
		System.out.println(currentRoom.enterTheRoom(this));
	}

	/**
	 * interpret the command that the player write
	 * @param command
	 */
	public void interpretCommand(String command) {
		switch(command){
			case"help":
				System.out.println(">description");
				System.out.println(">see weapons");
				System.out.println(">see armors");
				System.out.println(">see effects");
				System.out.println(">see potions");
				System.out.println(">use {num potions}");
				System.out.println(">equip {num armors}");
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
			case"see effects":
				System.out.println(player.getEffectDescription());
				return;
			case"see potions":
				System.out.println(player.getPotionDescription());
				return;
			case"state of health":
				System.out.println(player.getEtat());
				return;
		}
		
		String[] cmd=command.split(" ");
		
		if(cmd.length==2 && cmd[0].equals("equip")){
			
			try{
				int w=Integer.parseInt(cmd[1]);
				if(w>0)
					System.out.println(player.equip(w-1));
			}catch(NumberFormatException e){
				System.out.println("equip {num armor}");
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

	/**
	 * main function that ask the player for a command
	 */
	public void start() {
		initDungeon();
		String line ="";
		do {
			line = scanner.nextLine();
			interpretCommand(line);
		} while (!player.isDead());
		System.out.println("you are dead, you have survived "+GeneratorDungeon.numFloor+" floor(s)");
	}

	public Player getPlayer() {
		return player;
	}
}