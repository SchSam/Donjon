package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import furniture.Carpet;
import furniture.Furniture;
import furniture.FurnitureFactory;
import furniture.Wardrobe;

public class FurnitureTest {
	
	private Furniture wardrobe;
	private Furniture carpet;
	private Furniture test;
	
	@Before
	public void initFurnitureTest() {
		wardrobe = new Wardrobe();
		carpet = new Carpet();
		test = new Furniture("cmd test", "test", "descri test");
	}

	@Test
	public void testfurniture(){
		Assert.assertEquals(wardrobe.getCmd(),"look into wardrobe");
		Assert.assertEquals(carpet.getCmd(),"look under carpet");
		Assert.assertEquals(test.getCmd(),"cmd test");
		
		Assert.assertEquals(wardrobe.getName(),"wardrobe");
		Assert.assertEquals(carpet.getName(),"carpet");
		Assert.assertEquals(test.getName(),"test");
		
		Assert.assertEquals(test.agit(new Dungeon()),"descri test");
	}
	
	@Test
	public void furnitureFactory() {
		Furniture f;
		
		boolean f1 = false;
		boolean f2 = false;
		boolean f3 = false;
		boolean f4 = false;
		
		for(int i=0;i<100;i++){
			f=FurnitureFactory.getFurniture();
			if(f.getName().equals("wardrobe")){
				f1=true;
			}else if(f.getName().equals("carpet")){
				f2=true;
			}else if(f.getName().equals("picture")){
				f3=true;
			}else if(f.getName().equals("chandelier")){
				f4=true;
			}
		}
		Assert.assertTrue(f1);
		Assert.assertTrue(f2);
		Assert.assertTrue(f3);
		Assert.assertTrue(f4);
		
	}
	
}