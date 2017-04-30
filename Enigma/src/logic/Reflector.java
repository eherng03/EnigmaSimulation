package logic;

public class Reflector {

	private char[] letters;
	private int[] abecedario;
	
	public Reflector(char[] abc) {
		this.letters = abc;
		for(int i = 0; i < abc.length; i++){
			abecedario[i] = abc[i] - 'A'; 		//Le restamos 65 para que este en el rango de 0 a 
		}
	}
	
	public int convertir(int letter){
		return abecedario[letter];
	}
}
