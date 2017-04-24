package logic;

public class Machine {
	private final Rotor[] ROTORS = {
			new Rotor(("E K M F L G D Q V Z N T O W Y H X U S P A I B R C J").split(" ")),
			new Rotor(("A J D K S I R U X B L H W T M C Q G Z N P Y F V O E").split(" ")),
			new Rotor(("B D F H J L C P R T X V Z N Y E I W G A K M U S Q O").split(" ")),
			new Rotor(("E S O V P Z J A Y Q U I R H X L N F T G K D C M W B").split(" ")),
			new Rotor(("V Z B R G I T Y U P S D N H L X A W M J Q O F E C K").split(" ")),
			new Rotor(("J P G V O U M F Y Q B E N H Z R D K A S X L I C T W").split(" ")),
			new Rotor(("N Z J H G R C X M Y S W B O U F A I V L P E K Q D T").split(" ")),
			new Rotor(("F K Q H T L X O C B J S P D Z R A M E W N I U Y G V").split(" "))};
	
	
	private final Reflector[] REFLECTORS = {
			new Reflector(("E J M Z A L Y X V B W F C R Q U O N T S P I K H G D").split(" ")),
			new Reflector(("Y R U H Q S L D P X N G O K M I E B F Z C W V J A T").split(" ")),
			new Reflector(("F V P J I A O Y E D R Z X W G C T K U Q S B N M H L").split(" "))};
	
	private Rotor leftRotor;
	private Rotor middleRotor;
	private Rotor rightRotor;
	private Reflector reflector;
	
	public Machine(int reflector, int leftRotor, int middleRotor, int rightRotor, char leftLetter, char middleLetter, char rightLetter) {
		this.reflector = REFLECTORS[reflector - 1];
		this.leftRotor = ROTORS[leftRotor - 1];
		this.middleRotor = ROTORS[middleRotor - 1];
		this.rightRotor = ROTORS[rightRotor - 1];
		
		this.leftRotor.setInitPosition(leftLetter);
		this.leftRotor.setInitPosition(leftLetter);
		this.leftRotor.setInitPosition(leftLetter);
		
		
	}
}
