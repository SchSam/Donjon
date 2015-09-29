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
		weapon = new Weapon("sword", 0, "None", 10, "cutting");
		weapon2 = new Weapon("test", 0, "None", 10, "test");
		monster = new Slime("slime",30,5);
	}

	@Test
	public void testMonster(){
		monster.takeDamage(weapon);
		Assert.assertEquals(monster.getLife(),30);
		monster.takeDamage(weapon2);
		Assert.assertEquals(monster.getLife(),30-10);
		Assert.assertEquals(monster.action(player),"the slime attacks you");
		Assert.assertEquals(player.getLife(),100-5);
		Assert.assertEquals(monster.getState(),"the slime is in good shape");
		monster.takeDamage(weapon2);
		Assert.assertEquals(monster.getState(),"the slime start being weak");
		monster.takeDamage(weapon2);
		Assert.assertEquals(monster.getState(),"the slime is weak");
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
