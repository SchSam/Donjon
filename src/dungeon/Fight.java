package dungeon;

import java.util.Scanner;

import monster.Monster;

import player.Player;


public class Fight {
	
	private Player player;
	private Monster monster;
	private final Scanner scanner = new Scanner(System.in);
	
	public Fight(Player player,Monster m) {
		this.player=player;
		this.monster=m;
	}
	
	public void interpretCommand(String command) {
		switch(command){
			case"help":
				System.out.println(">description");
				System.out.println(">see weapons");
				System.out.println(">see effets");
				System.out.println(">wait");
				System.out.println(">attack {num Weapon} (0 for punch)");
				break;
			case"description":
				System.out.println(getDescription());
				break;
			case"see weapons":
				player.getWeaponsDescription();
				break;
			case"360 no scope get rekt bitch":
				monster.setLife(0);
				break;
			case"see effets":
				player.getEffetDescription();
				break;
			case"wait":
				monster.agit(player);
				break;
			case"state of health":
				System.out.println(player.getEtat());
				break;
		}
		String[] cmd=command.split(" ");
		if(cmd.length==2 && cmd[0].equals("attack")){
			try{
				int w=Integer.parseInt(cmd[1]);
				System.out.println(monster.takeDommage(player.getWeapons(w)));
				if(!monster.isDead())
					System.out.println(monster.agit(player));
			}catch(NumberFormatException e){
				System.out.println("attack {num Weapon} (0 for punch)");
			}
		}
	}
	
	private String getDescription() {
		String s = "vs etes en combat contre un " + monster.getName() + "\n";
		s+=monster.getEtat();
		return s;
	}

	public void start() {
		String line ="";
		System.out.println("un "+monster.getName()  +" apparait (bili bili bili)");
		do {
			line = scanner.nextLine();
			interpretCommand(line);
		} while (!fightIsFinished());
		System.out.println("Vous avez survecu au "+monster.getName());
	}

	private boolean fightIsFinished() {
		return monster.isDead() || player.isDead();
	}
}
