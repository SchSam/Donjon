package test;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import room.Direction;
import room.Enigma;
import room.Room;
import room.RoomEnigma;
import room.RoomFactory;
import room.RoomMonster;
import room.RoomTrap;
public class RoomTest {
	
	private Dungeon dungeon;

	@Before
	public void initRoomTest() {
		dungeon=new Dungeon();
	}

	@Test
	public void testRoomEnigma(){
		String enigma = "test enigma";
		ArrayList<String> choices = new ArrayList<String>();
		choices.add("choice 1");
		choices.add("choice 2");
		choices.add("choice 3");
		choices.add("choice 4");
		String answer = "choice 1";
		Enigma e= new Enigma(enigma, choices, answer);
		Room room =new RoomEnigma(e);
		dungeon.initDungeon();
		dungeon.enterInRoom(room);
		Assert.assertTrue(room.getCommandes().equals(choices));
		Assert.assertEquals(dungeon.getPlayer().getLife(),100);
		dungeon.interpretCommand("choice 3");
		Assert.assertEquals(dungeon.getPlayer().getLife(),96);
		dungeon.interpretCommand("choice 1");
		Assert.assertEquals(dungeon.getPlayer().getLife(),96);
		Assert.assertFalse(room.getCommandes().equals(choices));
		dungeon.enterInRoom(room);
		Assert.assertFalse(room.getCommandes().equals(choices));
	}
	
	@Test
	public void testRoomTrap(){
		Room room =new RoomTrap();
		dungeon.initDungeon();
		Assert.assertEquals(dungeon.getPlayer().getLife(),100);
		dungeon.enterInRoom(room);
		Assert.assertEquals(dungeon.getPlayer().getLife(),95);
		dungeon.enterInRoom(room);
		Assert.assertEquals(dungeon.getPlayer().getLife(),95);
	}
	
	@Test
	public void testRoomCommand(){
		Room room = new Room();
		Room room2 = new Room();
		dungeon.initDungeon();
		room.setDoors("test 2", room2);
		dungeon.enterInRoom(room);
		room.interpretCommand("test 1", dungeon);
		Assert.assertEquals(dungeon.getCurrentRoom(),room);
		Assert.assertNotEquals(dungeon.getCurrentRoom(),room2);
		dungeon.enterInRoom(room);
		room.interpretCommand("test 2", dungeon);
		Assert.assertNotEquals(dungeon.getCurrentRoom(),room);
		Assert.assertEquals(dungeon.getCurrentRoom(),room2);
	}

	@Test
	public void directionTest(){
		Assert.assertEquals(Direction.getContraire("go to wardrobe"),"go to wardrobe");
		Assert.assertEquals(Direction.getContraire("go to the hatch under Carpet"),"go to the hatch above");
		Assert.assertEquals(Direction.getContraire("go north"),"go south");
		Assert.assertEquals(Direction.getContraire("go 1"),"go 1");
	}
	
	@Test
	public void roomFactory() {
		Room r= new Room();
		
		boolean r1 = false;
		boolean r2 = false;
		boolean r3 = false;
		
		for(int i=0;i<100;i++){
			r=RoomFactory.getRoom(r);
			if(r instanceof RoomTrap){
				r1=true;
			}else if(r instanceof RoomEnigma){
				r2=true;
			}else if(r instanceof RoomMonster){
				r3=true;
			}
		}
		Assert.assertTrue(r1);
		Assert.assertTrue(r2);
		Assert.assertTrue(r3);
	}
}
