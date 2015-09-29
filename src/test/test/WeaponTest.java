package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import monster.Monster;
import weapon.Weapon;
import weapon.WeaponFactory;

public class WeaponTest {
	
	private Weapon weapon;
	private Weapon weaponEmply;
	private Monster monster;
	private Monster monster2;
	private Monster monster3;
	
	@Before
	public void initWeaponTest() {
		weapon = new Weapon("testgun", 10, "mun test", 20, "test");
		weaponEmply = new Weapon("testgun", 0, "mun test", 20, "test");
		monster = new Monster("testmonstre", 100, 10);
		monster2 = new Monster("testmonstre2", 60, 10);
		monster3 = new Monster("testmonstre3", 30, 10);
	}

	@Test
	public void testWeapon(){
		Assert.assertEquals(weapon.getName(),"testgun");
		Assert.assertEquals(weapon.getTypeWeapon(),"test");
		Assert.assertEquals(weapon.getTypeAmmo(),"mun test");
		Assert.assertEquals(weapon.getPower(),20);
		Assert.assertEquals(weapon.getNbAmmo(),10);
		
		Assert.assertTrue(weapon.getDescription().contains("name : testgun"));
		
		Assert.assertTrue(weapon.attack(monster).contains("the testmonstre almost took no dammage :("));
		Assert.assertEquals(monster.getLife(),100-20);
		
		Assert.assertTrue(weapon.attack(monster2).contains("the testmonstre2 took few dammages :|"));
		Assert.assertEquals(monster2.getLife(),60-20);
		
		Assert.assertTrue(weapon.attack(monster3).contains("the testmonstre3 got rekt :)"));
		Assert.assertEquals(monster3.getLife(),30-20);
		
		Assert.assertTrue(weapon.attack(monster).contains("testmonstre take 20 dmg"));
		Assert.assertEquals(monster.getLife(),100-20-20);
		
		Assert.assertEquals(weaponEmply.attack(monster),"your testgun has no mun test left");
		Assert.assertEquals(monster.getLife(),100-20-20);
	}
	
	@Test
	public void weaponFactory() {
		Weapon w;
		
		boolean w1 = false;
		boolean w2 = false;
		boolean w3 = false;
		boolean w4 = false;
		
		for(int i=0;i<100;i++){
			w=WeaponFactory.getWeapon(5);
			if(w.getName().equals("shotgun")){
				w1=true;
			}else if(w.getName().equals("sword")){
				w2=true;
			}else if(w.getName().equals("magnum")){
				w3=true;
			}else if(w.getName().equals("laser-saber")){
				w4=true;
			}
		}
		Assert.assertEquals(WeaponFactory.punch.getName(), "punch");
		Assert.assertEquals(WeaponFactory.punch.getTypeWeapon(), "punch");
		Assert.assertEquals(WeaponFactory.punch.getTypeAmmo(), "None");
		Assert.assertTrue(w1);
		Assert.assertTrue(w2);
		Assert.assertTrue(w3);
		Assert.assertTrue(w4);
		
	}
	
}