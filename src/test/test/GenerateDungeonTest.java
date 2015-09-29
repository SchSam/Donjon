package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dungeon.GeneratorDungeon;

import room.Enigma;
import room.Room;
import room.RoomEnigma;
import room.RoomMonster;
import room.RoomTrap;

public class GenerateDungeonTest {

	
	@Test
	public void testCreateRoom(){
		for(int i = 0;i<100;i++){
			Assert.assertFalse(GeneratorDungeon.createRoom(new RoomTrap()) instanceof RoomTrap);
			Assert.assertFalse(GeneratorDungeon.createRoom(new RoomEnigma(new Enigma("", new ArrayList<String>(), ""))) instanceof RoomEnigma);
			Assert.assertFalse(GeneratorDungeon.createRoom(new RoomMonster()) instanceof RoomMonster);
			Room room = GeneratorDungeon.createRoom(new Room(),"go south");
			System.out.println(room.getDoors().keySet());
			GeneratorDungeon.nbVisitedRoom=0;
			Assert.assertTrue(room.getDoors().keySet().contains("go north"));
		}
		
	}

}
