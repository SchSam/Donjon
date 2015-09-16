package dungeon;
import java.util.Scanner;

import room.Room;

public class Dungeon {
	
	
	protected Room currentRoom;
	protected boolean gameIsFinished = false;
	protected final Scanner scanner = new Scanner(System.in);

	public void initDungeon(){
		currentRoom = GeneratorDungeon.createRoom();
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public boolean interpretCommand(String command) {
		switch(command){
			case"description":
				System.out.println(currentRoom.getDescription());
				return false;
		
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
}