package logic;

public class Reflector {

	private String[] letters;
	private int initPosition;
	
	public Reflector(String[] letters) {
		this.letters = letters;
	}
	
	public void setPosition(int initPosition){
		this.initPosition = initPosition;
	}
}
