package room;

public enum Direction {
	
	go_north(new String[]{"go north","go south"}),
	go_south(new String[]{"go south","go north"}),
	go_east(new String[]{"go east","go west"}),
	go_west(new String[]{"go west","go east"}),
	go_hatchUp(new String[]{"go to the hatch above","go to the hatch below"}),
	go_hatchDown(new String[]{"go to the hatch below","go to the hatch above"});
	
	private String[] direction;

	Direction(String[] s) {
		direction=s;
	}
	
	public String getDirection() {
		return direction[0];
	}
	
	public String getContraire(){
		return direction[1];
	}
	
	public static String getContraire(String s){
		if(s.equals("go to wardrobe")){
			return "go to wardrobe";
		}else if(s.equals("go to the hatch under Carpet")){
			return Direction.go_hatchUp.getDirection();
		}
		
		for(Direction d : values())
			if(d.getDirection().equals(s))
				return d.getContraire();
		
		return s;
		
	}
	
	public static String getDirection(int i){
		return Direction.values()[i].getDirection();
	}
	
}
