package test;

import monster.Monster;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import player.Player;
import weapon.Weapon;
import dungeon.Fight;

public class FightTest {
	
	private Fight f;
	private Player player;
	
	@Before
	public void initTestFight(){
		player=new Player(100);
		player.addWeapon(new Weapon("test", 0, "None", 10, "truc"));
		f=new Fight(player,new Monster("testMonster", 15, 10));
	}
	
	@Test
	public void testFightAttack(){
		
		Assert.assertEquals(f.getDescription(),"you're fighting against a testMonster\nthe testMonster is in good shape");
		f.interpretCommand("attack lighting");
		Assert.assertFalse(f.fightIsFinished());
		f.interpretCommand("attack 0");
		Assert.assertFalse(f.fightIsFinished());
		Assert.assertEquals(player.getLife(),90);
		f.interpretCommand("attack 1");
		Assert.assertTrue(f.fightIsFinished());
		
	}
	
	@Test
	public void testFightCmdCheat(){
		
		f.interpretCommand("360 no scope get rekt bitch");
		Assert.assertTrue(f.fightIsFinished());
		
	}
}
