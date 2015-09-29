package test;

import monster.Monster;
import monster.MonsterFactory;
import monster.Slime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import player.Player;

import weapon.Weapon;
public class MonsterTest {

	
	private Weapon weapon;
	private Player player;
	private Slime monster;
	private Weapon weapon2;

	@Before
	public void initMonsterTest() {
		player =new Player(100);
		weapon = new Weapon("sword", 0, "None", 10, "coupant");
		weapon2 = new Weapon("test", 0, "None", 10, "test");
		monster = new Slime("slime",30,5);
	}

	@Test
	public void testMonster(){
		monster.takeDommage(weapon);
		Assert.assertEquals(monster.getLife(),30);
		monster.takeDommage(weapon2);
		Assert.assertEquals(monster.getLife(),30-10);
		Assert.assertEquals(monster.agit(player),"le slime vous attaque");
		Assert.assertEquals(player.getLife(),100-5);
		Assert.assertEquals(monster.getEtat(),"le slime est en plein forme");
		monster.takeDommage(weapon2);
		Assert.assertEquals(monster.getEtat(),"le slime commence a faiblir");
		monster.takeDommage(weapon2);
		Assert.assertEquals(monster.getEtat(),"le slime est faible");
	}
	
	@Test
	public void monsterFactory() {
		Monster m;
		
		boolean m1 = false;
		boolean m2 = false;
		
		for(int i=0;i<100;i++){
			m=MonsterFactory.getMonster(5);
			if(m.getName().equals("monster")){
				m1=true;
			}else if(m.getName().equals("slime")){
				m2=true;
			}
		}
		Assert.assertTrue(m1);
		Assert.assertTrue(m2);
	}
}
