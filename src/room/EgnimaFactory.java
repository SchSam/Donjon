package room;

import java.util.ArrayList;
import java.util.Random;
/**
 * The EnigmaFactory class let the game generates different types of enigmas.
 * 
 * @author bricout
 *
 */
public class EgnimaFactory {
	/**
	 * Creates a random enigma whose stats depends of the level specified.
	 * 
	 * @param level the level of the current dungeon.
	 *
	 * @return a randomly created enigma.
	 */
	public static Enigma getEgnima() {
			
			int r=new Random().nextInt(2);
			String enigma;
			ArrayList<String> choices=new ArrayList<String>();
			String answer;
			
			switch(r){
				case 0:
					enigma="who are gods here?";
					choices.add("remy and lucas");
					choices.add("eliott and samuel");
					choices.add("edouard and julien");
					choices.add("olive and tom");
					answer="eliott and samuel";
					return new Enigma(enigma, choices, answer);
				case 1:
					enigma="which is the well known answer of the famous game \"qui veut gagner de l'argent en masse\" ?";
					choices.add("baguette");
					choices.add("i don't know");
					choices.add("42");
					choices.add("la reponse d");
					answer="la reponse d";
					return new Enigma(enigma, choices, answer);
			}
			return null ;
		

	}

}
