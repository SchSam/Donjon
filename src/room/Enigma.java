package room;

import java.util.ArrayList;

public class Enigma {
	
	private String enigma;
	private ArrayList<String> choices;
	private String answer;
	
	public Enigma(String enigma, ArrayList<String> choices, String answer) {
		this.enigma = enigma;
		this.choices = choices;
		this.answer = answer;
	}

	public String getEnigma() {
		return enigma;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public String getAnswer() {
		return answer;
	}
	
	public boolean userchoice(String s){
		return s.equals(answer);
	}
}
