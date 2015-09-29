package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import player.Player;
import potion.PotionFactory;
import weapon.Weapon;
import weapon.WeaponFactory;

public class PlayerTest {

	private Player player;

	@Before
	public void initMonsterTest() {
		player =new Player(100);
	}
	
	@Test
	public void testWeaponPlayer(){
		Weapon weapon=new Weapon("test 1", 0, "", 0, "");
		player.addWeapon(weapon);
		Assert.assertEquals(player.getWeapons().size(), 1);
		Assert.assertEquals(player.getWeapons(0), WeaponFactory.punch);
		Assert.assertEquals(player.getWeapons(1), weapon);
		Assert.assertTrue(player.getWeaponsDescription().contains("My weapons : "));
		player.addPotion(PotionFactory.getPotion(0));
		Assert.assertTrue(player.getPotionDescription().contains("My potions : "));
	}
	
	@Test
	public void testEtat(){
		Assert.assertEquals(player.getEtat(), "100/100");
		player.setLife(50);
		Assert.assertEquals(player.getEtat(), "50/100");
		Assert.assertEquals(player.isDead(), false);
		player.setLife(0);
		Assert.assertEquals(player.isDead(), true);
	}
	
}
