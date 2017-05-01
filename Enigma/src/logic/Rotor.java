package logic;

public class Rotor {
	//https://github.com/CollinJ/Enigma
	private int change1;		//When the rotor reachs this position changes the next rotor
	private int change2;
	private int currentPosition;
	private char[] letters;
	private int[] abecHaciaDelante;
	private int[] abecHaciaAtras;
	
	/**
	 * 
	 * @param ds
	 * @param change1
	 * @param change2
	 */
	public Rotor(char[] ds, char change1, char change2) {
		this.letters = ds;
		abecHaciaDelante = new int[letters.length];
		abecHaciaAtras = new int[letters.length];
		for(int i = 0; i < ds.length; i++){
			abecHaciaDelante[i] = ds[i] - 'A'; 		//Le restamos 65 para que este en el rango de 0 a 
		}
		for(int i =0; i<26; i++){
			abecHaciaAtras[abecHaciaDelante[i]] = i;
		}
		this.change1 = change1 - 'A';
		if(change2 != ' ')
			this.change2 = change2 - 'A';
	}
	
	/**
	 * 
	 * @param initPosition
	 */
	public void setCurrentPosition(char currentPosition){
		for(int i = 0; i < letters.length; i++){
			if(letters[i] == currentPosition){
				this.currentPosition = currentPosition - 'A';		//A está entre [0, 25]
				break;
			}
		}
	}
	
	/**
	 * 
	 */
	public void advance(){
		currentPosition = (currentPosition + 1)%26;
	}
	
	/**
	 * 
	 * @param letra a convertir, a=0, b=1, c=2 etc
	 * @return
	 */
	public int convertDelante(int letter){
		return abecHaciaDelante[(currentPosition + letter)%26];
	}
	
	/**
	 * 
	 * @param letra a convertir, a=0, b=1, c=2 etc
	 * @return
	 */
	public int convertDetras(int letter){
		return abecHaciaAtras[(currentPosition + letter)%26];
	}
	
	public boolean isInChangePosition(){
		return (currentPosition == change1 || currentPosition == change2);
	}
	
}
