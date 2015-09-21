package room;

import java.util.ArrayList;
import java.util.Random;

import Armor.ArmorFactory;
import Effet.EffetFactory;
import Monster.MonsterFactory;
import Player.WeaponFactory;
import Potion.PotionFactory;

import dungeon.Dungeon;
import dungeon.Parametre;

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
			int r=new Random().nextInt(8);
			r=3;
			// new door
			switch(r){
			case 0:
				setDoors("passer par l'armoire", null);
				System.out.println("There is a hidden door in this wardrobe.");
				break;
			case 1:
				System.out.println("It's empty.");
				break;
			case 2:
				System.out.println("It is a trap !");
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
				MonsterFactory.getEffet(Parametre.numEtage);
				break;
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
