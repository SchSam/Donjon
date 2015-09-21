package dungeon;
import java.util.Scanner;

import Player.Player;

import room.Room;

public class Dungeon {
	
	
	private Room currentRoom;
	private boolean gameIsFinished = false;
	private final Scanner scanner = new Scanner(System.in);
	private Player player;

	public void initDungeon(){
		setPlayer(new Player());
		Parametre.numEtage=0;
		currentRoom = GeneratorDungeon.genereNewStage();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
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
			default:
				return currentRoom.interpretCommand(command, this);
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
			System.out.println(getCurrentRoom().getDescription());
			do{
				line = scanner.nextLine();
			}while(!interpretCommand(line));
			
		} while (!gameIsFinished());
		System.out.println("You are in " + getCurrentRoom().getDescription());
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}

	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}

	public boolean gameIsLost() {
		return currentRoom.equals("trap");
	}

	public boolean gameIsWon() {
		return currentRoom.equals("exit");
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isGameIsFinished() {
		return gameIsFinished;
	}

	public void setGameIsFinished(boolean gameIsFinished) {
		this.gameIsFinished = gameIsFinished;
	}
}