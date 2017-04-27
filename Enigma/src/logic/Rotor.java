package logic;

public class Rotor {

	private int initPosition;
	private int currentPosition;
	private String[] letters;
	private int[] abecedarioNumerico;
	
	public Rotor(String[] letters) {
		this.letters = letters;
		for(int i = 0; i < letters.length; i++){
			abecedarioNumerico[i] = letters[i].toCharArray()[0] - 'A'; 		//Le restamos 65 para que este en el rango de 0 a 
		}
	}
	
	public void setInitPosition(char initPosition){
		for(int i = 0; i < letters.length; i++){
			if(letters[i].equals(initPosition)){
				
			}
		}
		//TODO cambiar, buscar el char en el alfabeto
		this.initPosition = initPosition;
		currentPosition = initPosition;
	}
}
