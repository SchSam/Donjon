package test;

import org.junit.Before;
import org.junit.Test;

import armor.Armor;
import armor.ArmorFactory;
import armor.ArmorSlime;
import monster.Monster;
import monster.Slime;
import player.Player;

import org.junit.Assert;


public class ArmorTest {
	
	private Armor armor;
	private Armor armorslime;
	private Monster monster;
	private Monster slime;

	@Before
	public void initArmorTest() {
		this.armor = new Armor("armor",3,0.50);
		this.armorslime = new ArmorSlime("armorslime",4,0.50);
		this.monster = new Monster("monster", 10, 5);
		this.slime = new Slime("slime", 10, 20);
	}
	
	@Test
	public void getDommageTest(){
		int d =armor.getDamage(monster);
		// 5 - 3 - (5-3) * 0.5 = 1
		Assert.assertEquals(d,1);
		
		d =armorslime.getDamage(monster);
		// 5 - 4 - (5-4) * 0.5 = 0 (round)
		Assert.assertEquals(d,0);
		
		d =armor.getDamage(slime);
		// 20 - 3 - (20-3) * 0.5 = 8
		Assert.assertEquals(d,8);
		
		d =armorslime.getDamage(slime);
		// 0 effect armor
		Assert.assertEquals(d,0);
	}
	
	@Test
	public void getNameTest(){
		Assert.assertEquals(armor.getName(),"armor");
		Assert.assertEquals(armorslime.getName(),"armorslime");
	}
	
	@Test
	public void getDescription() {
		String s="reduced "+3+" dmg\n";
		s+="reduced "+50+"% dmg\n";
		String s2="this armor is invulnerable to slimes\n";
		s2+="reduced "+4+" dmg\n";
		s2+="reduced "+50+"% dmg\n";
		Assert.assertEquals(armor.getDescription(),s);
		Assert.assertEquals(armorslime.getDescription(),s2);
	}

	@Test
	public void armorFactory() {
		Armor a;
		boolean b1 = false;
		boolean b2 = false;
		for(int i=0;i<100;i++){
			a=ArmorFactory.getArmor(5);
			if(a.getName().equals("iron armor")){
				b1=true;
			}else if(a.getName().equals("slime armor")){
				b2=true;
			}
		}
		Assert.assertTrue(b1);
		Assert.assertTrue(b2);
	}
	
	@Test
	public void playerArmorTest(){
		Player player = new Player(100);
		player.addArmor(armor);
		player.addArmor(armorslime);
		Assert.assertFalse(player.getArmorDescription().contains("(equip)"));
		Assert.assertEquals(player.getArmors().size(), 2);
		Assert.assertEquals(player.equip(0),"equip armor number 1");
		Assert.assertTrue(player.getArmorDescription().contains("(equip)"));
		Assert.assertEquals(player.getArmor(), armor);
		Assert.assertEquals(player.equip(1),"equip armor number 2");
		Assert.assertTrue(player.getArmorDescription().contains("(equip)"));
		Assert.assertEquals(player.getArmor(), armorslime);
		
	}
}
