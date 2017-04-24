package graphic;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Machine;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Eva
 *
 */
public class SelectRotorsWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel image;
	private JTextField txtSeleccioneTresRotores;
	private MainWindow parent;

	JComboBox<Integer> rotorIzq;
	JComboBox<Character> letraIzq;
	JComboBox<Integer> rotorDerecho;
	JComboBox<Character> letraDerecho;
	JComboBox<Integer> rotorMedio;
	JComboBox<Character> letraMedio;
	private JComboBox<Integer> reflector;

	

	/**
	 * Create the frame.
	 */
	public SelectRotorsWindow(MainWindow parent) {
		this.parent = parent;
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 693);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 55, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		image = new EnigmaImage(414, 239);
		image.setBounds(128, 11, 414, 239);
		contentPane.add(image);
		
		txtSeleccioneTresRotores = new JTextField();
		txtSeleccioneTresRotores.setEditable(false);
		txtSeleccioneTresRotores.setText("Seleccione tres rotores, y un reflector de los siguientes, y la letra por la que empiezan");
		txtSeleccioneTresRotores.setBounds(118, 261, 436, 20);
		contentPane.add(txtSeleccioneTresRotores);
		txtSeleccioneTresRotores.setColumns(10);
		
		
		createTextField("Rotor 1:  E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", 10, 292, 311, 20);
		createTextField("Rotor 2:  A J D K S I R U X B L H W T M C Q G Z N P Y F V O E", 10, 323, 311, 20);
		createTextField("Rotor 3:  B D F H J L C P R T X V Z N Y E I W G A K M U S Q O", 10, 354, 311, 20);
		createTextField("Rotor 4:  E S O V P Z J A Y Q U I R H X L N F T G K D C M W B", 10, 385, 311, 20);
		createTextField("Rotor 5:  V Z B R G I T Y U P S D N H L X A W M J Q O F E C K", 10, 416, 311, 20);
		createTextField("Rotor 6:  J P G V O U M F Y Q B E N H Z R D K A S X L I C T W", 10, 447, 311, 20);
		createTextField("Rotor 7:  N Z J H G R C X M Y S W B O U F A I V L P E K Q D T", 10, 478, 311, 20);
		createTextField("Rotor 8:  F K Q H T L X O C B J S P D Z R A M E W N I U Y G V", 10, 509, 311, 20);
		
		createTextField("Reflector 1:  E J M Z A L Y X V B W F C R Q U O N T S P I K H G D", 336, 292, 320, 20);
		createTextField("Reflector 2:  Y R U H Q S L D P X N G O K M I E B F Z C W V J A T", 336, 323, 320, 20);
		createTextField("Reflector 3:  F V P J I A O Y E D R Z X W G C T K U Q S B N M H L", 336, 323, 320, 20);
		
		createTextField("Rotor Izquierdo", 109, 540, 86, 20);
		createTextField("Rotor Medio", 224, 540, 86, 20);
		createTextField("Rotor Derecho", 339, 540, 86, 20);
		createTextField("Reflector", 454, 540, 86, 20);
		
		createTextField("Rotor número:", 10, 573, 86, 20);
		createTextField("Primera letra", 10, 604, 86, 20);
		
		
		//====================================================
		//					ROTOR IZQUIERDO
		//====================================================
		rotorIzq = new JComboBox<>();
		rotorIzq.setBounds(109, 573, 86, 20);
		fillRotorComboBox(rotorIzq);
		contentPane.add(rotorIzq);
		
		letraIzq = new JComboBox<>();
		letraIzq.setBounds(109, 604, 86, 20);
		fillLetterComboBox(letraIzq);
		contentPane.add(letraIzq);
		//====================================================
		//					ROTOR MEDIO
		//====================================================
		rotorMedio = new JComboBox<>();
		rotorMedio.setBounds(224, 573, 86, 20);
		fillRotorComboBox(rotorMedio);
		contentPane.add(rotorMedio);
		
		letraMedio = new JComboBox<>();
		letraMedio.setBounds(224, 604, 86, 20);
		fillLetterComboBox(letraMedio);
		contentPane.add(letraMedio);
		
		//====================================================
		//					ROTOR DERECHO
		//====================================================
		rotorDerecho = new JComboBox<>();
		rotorDerecho.setBounds(339, 573, 86, 20);
		fillRotorComboBox(rotorDerecho);
		contentPane.add(rotorDerecho);
		
		letraDerecho = new JComboBox<>();
		letraDerecho.setBounds(339, 604, 86, 20);
		fillLetterComboBox(letraDerecho);
		contentPane.add(letraDerecho);
		
		
		//====================================================
		//					   REFLECTOR
		//====================================================
		reflector = new JComboBox<>();
		reflector.setBounds(454, 573, 86, 20);
		for(int i = 1; i < 4; i++){
			reflector.addItem(i);
		}
		reflector.setSelectedItem(1);
		contentPane.add(reflector);
		
		
		//====================================================
		//						ACEPTAR
		//====================================================
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkRotors()){
					createMachine();
				}
			}
		});
		btnAceptar.setBounds(569, 572, 86, 52);
		contentPane.add(btnAceptar);
		
		
	}
	
	
	

	protected void createMachine() {
		int reflector = (int) this.reflector.getSelectedItem();
		int leftRotor = (int) rotorIzq.getSelectedItem();
		int middleRotor = (int) rotorMedio.getSelectedItem();
		int rightRotor = (int) rotorDerecho.getSelectedItem();
		
		char leftLetter = (char) letraIzq.getSelectedItem();
		char middleLetter = (char) letraMedio.getSelectedItem();
		char rightLetter = (char) letraDerecho.getSelectedItem();
		
		//TODO alba separar logica de fisica
		Machine enigma = new Machine(reflector, leftRotor, middleRotor, rightRotor, leftLetter, middleLetter,rightLetter);
	}

	/**
	 * Check if the selected rotors are different.
	 * @return true if they are different
	 * @return false if not
	 */
	protected boolean checkRotors() {
		if(rotorIzq.getSelectedItem() != null && rotorMedio.getSelectedItem() != null && rotorDerecho.getSelectedItem() != null){
			if((!rotorIzq.getSelectedItem().toString().equals(rotorMedio.getSelectedItem().toString())) && 
					(!rotorIzq.getSelectedItem().toString().equals(rotorDerecho.getSelectedItem().toString())) &&
					(!rotorMedio.getSelectedItem().toString().equals(rotorDerecho.getSelectedItem().toString()))){
				return true;
			}
		}
	
		return false;
	}

	/**
	 * 
	 * @param string
	 * @param i
	 * @param j
	 * @param k
	 * @param l
	 */
	private void createTextField(String string, int i, int j, int k, int l) {
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setText(string);
		textField.setBounds(i, j, k, l);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	
	/**
	 * 
	 * @param rotor
	 */
	private void fillRotorComboBox(JComboBox<Integer> rotor){
		for(int i = 1; i < 9; i++){
			rotor.addItem(i);
		}
		rotor.setSelectedItem(Integer.toString(1));
	}
	
	
	/**
	 * 
	 * @param rotor
	 */
	private void fillLetterComboBox(JComboBox<Character> rotor){
		for(int i = 65; i < 91; i++){
			rotor.addItem((char) i);
		}
		rotor.setSelectedItem((char) 65);
	}
	
}
