package logic;

public class Rotor {

	private int initPosition;
	private int currentPosition;
	private String[] letters;
	
	public Rotor(String[] letters) {
		this.letters = letters;
	}
	
	public void setInitPosition(char initPosition){
		
		//TODO cambiar, buscar el char en el alfabeto
		this.initPosition = initPosition;
		currentPosition = initPosition;
	}
}
