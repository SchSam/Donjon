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
	
	/**
	 * interpret the command that the player write
	 * @param command
	 */
	public void interpretCommand(String command) {
		switch(command){
			case"help":
				System.out.println(">description");
				System.out.println(">see weapons");
				System.out.println(">see effects");
				System.out.println(">wait");
				System.out.println(">attack {num Weapon} (0 for punch)");
				break;
			case"description":
				System.out.println(getDescription());
				break;
			case"see weapons":
				System.out.println(player.getWeaponsDescription());
				break;
			case"360 no scope get rekt bitch":
				monster.setLife(0);
				break;
			case"see effects":
				System.out.println(player.getEffectDescription());
				break;
			case"wait":
				System.out.println(monster.action(player));
				break;
			case"state of health":
				System.out.println(player.getEtat());
				break;
		}
		String[] cmd=command.split(" ");
		if(cmd.length==2 && cmd[0].equals("attack")){
			try{
				int w=Integer.parseInt(cmd[1]);
				System.out.println(monster.takeDamage(player.getWeapons(w)));
				if(!monster.isDead())
					System.out.println(monster.action(player));
			}catch(NumberFormatException e){
				System.out.println("attack {num Weapon} (0 for punch)");
			}
		}
	}
	
	/**
	 * 
	 * @return description fight
	 */
	public String getDescription() {
		String s = "you're fighting against a " + monster.getName() + "\n";
		s+=monster.getState();
		return s;
	}

	/**
	 * loop that manages the user command
	 */
	public void start() {
		String line ="";
		System.out.println("a "+monster.getName()  +" appears (bili bili bili)");
		do {
			line = scanner.nextLine();
			interpretCommand(line);
		} while (!fightIsFinished());
		System.out.println("You have survived the "+monster.getName());
	}

	/**
	 * @return if fight is finished
	 */
	public boolean fightIsFinished() {
		return monster.isDead() || player.isDead();
	}
}
