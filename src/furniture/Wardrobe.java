package furniture;

import java.util.Random;

import monster.Monster;
import monster.MonsterFactory;
import potion.PotionFactory;
import room.Room;
import weapon.WeaponFactory;
import armor.ArmorFactory;
import dungeon.Dungeon;
import dungeon.Fight;
import dungeon.GeneratorDungeon;
import effect.EffectFactory;

public class Wardrobe extends Furniture {

	private boolean isOpen;
	
	public Wardrobe() {
		super("look into wardrobe", "wardrobe", "this is a wardrobe");
		isOpen=false;
	}
	
	/**
	 * Wardrobe is open or not ?
	 * @param isOpen
	 */
	public Wardrobe(boolean isOpen) {
		super("look into wardrobe", "wardrobe", "this is a wardrobe");
		this.isOpen=isOpen;
	}
	
	@Override
	public String agit(Dungeon dungeon){
		if(isOpen)
			return super.agit(dungeon);
		
		String s="";
		Random r=new Random();
		int x=r.nextInt(8);
		switch(x){
			case 0:
				Room room=GeneratorDungeon.createRoom();
				dungeon.getCurrentRoom().setDoors("go to wardrobe", room);
				room.setDoors("go to wardrobe", dungeon.getCurrentRoom());
				room.setFurnitures(this.getCmd(), this);
				s="There is a hidden door in this wardrobe";
				break;
			case 1:
				s="It's empty.";
				break;
			case 2:
				s="It is a trap !";
				dungeon.getPlayer().setLife(dungeon.getPlayer().getLife()-r.nextInt(GeneratorDungeon.numEtage*3));
				break;
			case 3:
				s="There is a weapons in this wardrobe";
				dungeon.getPlayer().addWeapon(WeaponFactory.getWeapon(GeneratorDungeon.numEtage));
				break;
			case 4:
				s="There is a potions in this wardrobe";
				dungeon.getPlayer().addPotion(PotionFactory.getPotion(GeneratorDungeon.numEtage));
				break;
			case 5:
				s="There is a effect in this wardrobe";
				dungeon.getPlayer().addEffet(EffectFactory.getEffet(GeneratorDungeon.numEtage));
				break;
			case 6:
				s="There is a armor in this wardrobe";
				dungeon.getPlayer().addArmor(ArmorFactory.getArmor(GeneratorDungeon.numEtage));
				break;
			case 7:
				s="There is a monster in this wardrobe";
				Monster monster=MonsterFactory.getMonster(GeneratorDungeon.numEtage);
				new Fight(dungeon.getPlayer(),monster).start();
				break;
		}
		isOpen=true;
		return s;
	}
	
}
