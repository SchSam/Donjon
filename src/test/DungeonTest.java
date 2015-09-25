package test;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DungeonTest {
	
	protected Dungeon dungeon;

	@Before
	public void createDungeon() {
		dungeon = new Dungeon();
	}

	
}