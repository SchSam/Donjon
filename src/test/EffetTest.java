package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import effet.Effet;
import effet.EffetAntidote;
import effet.EffetFactory;
import effet.EffetPoison;
import player.Player;


public class EffetTest {
	
	private Effet effetAep;
	private Effet effetAe;
	
	@Before
	public void initEffetTest() {
		effetAep = new EffetAntidote(EffetPoison.class);
		effetAe = new EffetAntidote(Effet.class);
	}

	@Test
	public void effetPoisonAntidote(){
		Player player= new Player(100);
		player.addEffet(new EffetPoison(2,4));
		Assert.assertEquals(player.getLife(), 98);
		player.agiteffets();
		Assert.assertEquals(player.getLife(), 96);
		player.addEffet(new EffetPoison(2,4));
		Assert.assertEquals(player.getEffets().size(), 2);
		Assert.assertEquals(player.getLife(), 94);
		Assert.assertTrue(player.getEffetDescription().contains("1) fait perdre quelques points de vie a chaque changement de salle (tour 2)"));
		player.agiteffets();
		Assert.assertEquals(player.getLife(), 90);
		player.agiteffets();
		Assert.assertEquals(player.getEffets().size(), 1);
		player.addEffet(effetAep);
		Assert.assertEquals(effetAep.getDescription(),"enleve les effets poison");
		Assert.assertEquals(player.getEffets().size(), 0);
		player.addEffet(new EffetPoison(2,4));
		player.addEffet(new EffetPoison(2,4));
		Assert.assertEquals(player.getEffets().size(), 2);
		player.addEffet(effetAe);
		Assert.assertEquals(effetAe.getDescription(),"enleve les effets");
		Assert.assertEquals(player.getEffets().size(), 0);
	}
	
	@Test
	public void effetFactory() {
		Effet e;
		
		boolean e1 = false;
		boolean e2 = false;
		boolean e3 = false;
		
		for(int i=0;i<100;i++){
			e=EffetFactory.getEffet(5);
			if(e.getDescription().equals("enleve les effets")){
				e1=true;
			}else if(e.getDescription().equals("enleve les effets poison")){
				e2=true;
			}else if(e.getDescription().contains("fait perdre quelques points de vie a chaque changement de salle (tour ")){
				e3=true;
			}
		}
		Assert.assertTrue(e1);
		Assert.assertTrue(e2);
		Assert.assertTrue(e3);
	}
	
}