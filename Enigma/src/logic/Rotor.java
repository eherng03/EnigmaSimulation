package logic;

public class Rotor {

	private int initPosition;
	private int currentPosition;
	private String[] letters;
	
	public Rotor(String[] letters) {
		this.letters = letters;
	}
	
	public void setPosition(int initPosition){
		this.initPosition = initPosition;
		currentPosition = initPosition;
	}
}
