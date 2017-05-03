package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Machine {
	//==========================================================================================
	private final Rotor[] ROTORS = {
			new Rotor(("EKMFLGDQVZNTOWYHXUSPAIBRCJ").toCharArray(), 'Q', ' '),
			new Rotor(("AJDKSIRUXBLHWTMCQGZNPYFVOE").toCharArray(), 'E', ' '),
			new Rotor(("BDFHJLCPRTXVZNYEIWGAKMUSQO").toCharArray(), 'V', ' '),
			new Rotor(("ESOVPZJAYQUIRHXLNFTGKDCMWB").toCharArray(), 'J', ' '),
			new Rotor(("VZBRGITYUPSDNHLXAWMJQOFECK").toCharArray(), 'Z', ' '),
			new Rotor(("JPGVOUMFYQBENHZRDKASXLICTW").toCharArray(), 'Z', 'M'),
			new Rotor(("NZJHGRCXMYSWBOUFAIVLPEKQDT").toCharArray(), 'Z', 'M'),
			new Rotor(("FKQHTLXOCBJSPDZRAMEWNIUYGV").toCharArray(), 'Z', 'M')};
	
	
	private final Reflector[] REFLECTORS = {
			new Reflector(("EJMZALYXVBWFCRQUONTSPIKHGD").toCharArray()),
			new Reflector(("YRUHQSLDPXNGOKMIEBFZCWVJAT").toCharArray()),
			new Reflector(("FVPJIAOYEDRZXWGCTKUQSBNMHL").toCharArray())};
	//==========================================================================================
	
	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private Reflector reflector;
	
	//==========================================================================================
	
	public Machine(int reflector, int leftRotor, int middleRotor, int rightRotor, char leftLetter, char middleLetter, char rightLetter) {
		this.reflector = REFLECTORS[reflector - 1];
		this.leftRotor = ROTORS[leftRotor - 1];
		this.middleRotor = ROTORS[middleRotor - 1];
		this.rightRotor = ROTORS[rightRotor - 1];
		
		this.leftRotor.setCurrentPosition(leftLetter);
		this.leftRotor.setCurrentPosition(leftLetter);
		this.leftRotor.setCurrentPosition(leftLetter);	
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public String cifrate(File file) throws IOException {
		StringBuilder mensajeCifrado = new StringBuilder();
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line = buffer.readLine();
		
		while (line != null) {
			line = line.toUpperCase();
			char[] characters = line.toCharArray();
			for(int i = 0; i < characters.length; i++){
				if(characters[i] == ' '){
					mensajeCifrado.append(' ');
				}else{
					mensajeCifrado.append(convertChar(characters[i]));
				}
			}
			mensajeCifrado.append("\n");
	        line = buffer.readLine();
	    }
		
		return mensajeCifrado.toString();
	}
	
	public char convertChar(char letter){
		int charNum = letter - 'A';
		moverRotors();
		int output;
		output = rightRotor.convertDelante(charNum);
		output = middleRotor.convertDelante(output);
		output = leftRotor.convertDelante(output);
		output = reflector.convertir(output);
		output = leftRotor.convertDetras(output);
		output = middleRotor.convertDetras(output);
		output = rightRotor.convertDetras(output);
		return (char) (output + 'A');
		
	}

	/**
	 * 
	 */
	private void moverRotors() {
		if (rightRotor.isInChangePosition()) {
			if(middleRotor.isInChangePosition()){
				leftRotor.advance();
			}
			middleRotor.advance();	
		}
		rightRotor.advance();
		
	}
}
