package room;

import java.util.ArrayList;
import java.util.Random;

import armor.ArmorFactory;

import monster.Monster;
import monster.MonsterFactory;

import potion.PotionFactory;
import weapon.WeaponFactory;


import dungeon.Dungeon;
import dungeon.Fight;
import dungeon.Parametre;
import effet.EffetFactory;

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
			Random r=new Random();
			int x=r.nextInt(2);
			if(x==1)
				x=3;
			else
				x=7;
			// new door
			switch(x){
			case 0:
				setDoors("passer par l'armoire", null);
				System.out.println("There is a hidden door in this wardrobe.");
				break;
			case 1:
				System.out.println("It's empty.");
				break;
			case 2:
				System.out.println("It is a trap !");
				dungeon.getPlayer().setLife(r.nextInt(Parametre.numEtage*3));
				break;
			case 3:
				System.out.println("There is a weapons in this wardrobe.");
				dungeon.getPlayer().addWeapon(WeaponFactory.getWeapon(Parametre.numEtage));
				break;
			case 4:
				System.out.println("There is a potions in this wardrobe.");
				dungeon.getPlayer().addPotion(PotionFactory.getPotion(Parametre.numEtage));
				break;
			case 5:
				System.out.println("There is a effect in this wardrobe.");
				dungeon.getPlayer().addEffet(EffetFactory.getEffet(Parametre.numEtage));
				break;
			case 6:
				System.out.println("There is a armor in this wardrobe.");
				dungeon.getPlayer().addArmor(ArmorFactory.getArmor(Parametre.numEtage));
				break;
			case 7:
				System.out.println("There is a monster in this wardrobe !");
				Monster monster=MonsterFactory.getMonster(Parametre.numEtage);
				new Fight(dungeon.getPlayer(),monster).start();
				armoire=false;
				return true;
				//test if the player is dead 
			default:
				break;
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
