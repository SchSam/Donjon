package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import effect.Effect;
import effect.EffectAntidote;
import effect.EffectPoison;
import player.Player;
import potion.Potion;
import potion.PotionFactory;


public class PotionTest {
	
	private Potion potion;
	private Potion potion2;
	private Player player;
	
	@Before
	public void initPotionTest() {
		Effect effet = new EffectPoison(2,4);
		Effect effet2 = new EffectAntidote(EffectPoison.class);
		potion = new Potion(effet, "poison");
		potion2 = new Potion(effet2, "antidote");
		player=new Player(100);
	}

	@Test
	public void testPotion(){
		player.addPotion(potion);
		Assert.assertEquals(player.getPotions().size(), 1);
		
		player.removePotion(potion);
		Assert.assertEquals(player.getPotions().size(), 0);
		
		player.addPotion(potion);
		Assert.assertEquals(player.usePotion(0),"potion number 1 use");
		Assert.assertEquals(player.getPotions().size(), 0);
		Assert.assertEquals(player.getEffects().size(), 1);
		Assert.assertEquals(player.getLife(), 98);
		
		player.addPotion(potion);
		player.addPotion(potion2);
		Assert.assertEquals(player.usePotion(1),"potion number 2 use");
		Assert.assertEquals(player.getEffects().size(), 0);
	}
	
	@Test
	public void potionFactory() {
		Potion p;
		
		boolean p1 = false;
		boolean p2 = false;
		
		for(int i=0;i<100;i++){
			p=PotionFactory.getPotion(5);
			if(p.getName().equals("poison")){
				p1=true;
			}else if(p.getName().equals("antidote")){
				p2=true;
			}
		}
		Assert.assertTrue(p1);
		Assert.assertTrue(p2);
	}
	
}