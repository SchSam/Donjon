package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import effect.Effect;
import effect.EffectAntidote;
import effect.EffectFactory;
import effect.EffectPoison;
import player.Player;


public class EffectTest {
	
	private Effect effectAep;
	private Effect effectAe;
	
	@Before
	public void initEffetTest() {
		effectAep = new EffectAntidote(EffectPoison.class);
		effectAe = new EffectAntidote(Effect.class);
	}

	@Test
	public void effetPoisonAntidote(){
		Player player= new Player(100);
		player.addEffect(new EffectPoison(2,4));
		Assert.assertEquals(player.getLife(), 98);
		player.executeeffects();
		Assert.assertEquals(player.getLife(), 96);
		player.addEffect(new EffectPoison(2,4));
		Assert.assertEquals(player.getEffects().size(), 2);
		Assert.assertEquals(player.getLife(), 94);
		Assert.assertTrue(player.getEffectDescription().contains("1) make you lose few hp everytime you move to another room (tour 2)"));
		player.executeeffects();
		Assert.assertEquals(player.getLife(), 90);
		player.executeeffects();
		Assert.assertEquals(player.getEffects().size(), 1);
		player.addEffect(effectAep);
		Assert.assertEquals(effectAep.getDescription(),"remove the effects poison");
		Assert.assertEquals(player.getEffects().size(), 0);
		player.addEffect(new EffectPoison(2,4));
		player.addEffect(new EffectPoison(2,4));
		Assert.assertEquals(player.getEffects().size(), 2);
		player.addEffect(effectAe);
		Assert.assertEquals(effectAe.getDescription(),"remove the effects");
		Assert.assertEquals(player.getEffects().size(), 0);
	}
	
	@Test
	public void effetFactory() {
		Effect e;
		
		boolean e1 = false;
		boolean e2 = false;
		boolean e3 = false;
		
		for(int i=0;i<100;i++){
			e=EffectFactory.getEffet(5);
			if(e.getDescription().equals("remove the effects")){
				e1=true;
			}else if(e.getDescription().equals("remove the effects poison")){
				e2=true;
			}else if(e.getDescription().contains("make you lose few hp everytime you move to another room (tour ")){
				e3=true;
			}
		}
		Assert.assertTrue(e1);
		Assert.assertTrue(e2);
		Assert.assertTrue(e3);
	}
	
}