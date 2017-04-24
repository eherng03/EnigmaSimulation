package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class SelectRorotsWindow extends JFrame {

	private JPanel contentPane;
	private JPanel image;
	private JTextField txtSeleccioneTresRotores;
	private JTextField textField_1;
	private JTextField txtRotorIzquierdo;
	private JTextField textField_2;
	private JTextField txtPrimeraLetra;
	private JTextField txtRotorNmero;
	private JTextField textField_3;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectRorotsWindow frame = new SelectRorotsWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectRorotsWindow() {
	
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
		
		createTextField("Reflector A:  E J M Z A L Y X V B W F C R Q U O N T S P I K H G D", 336, 292, 320, 20);
		createTextField("Reflector B:  Y R U H Q S L D P X N G O K M I E B F Z C W V J A T", 336, 323, 320, 20);
		createTextField("Reflector C:  F V P J I A O Y E D R Z X W G C T K U Q S B N M H L", 336, 323, 320, 20);
		
		createTextField("Rotor Izquierdo", 109, 540, 86, 20);
		createTextField("Rotor Medio", 235, 540, 86, 20);
		createTextField("Rotor Derecho", 348, 540, 86, 20);
		
		createTextField("Primera letra", 10, 604, 86, 20);
		createTextField("Rotor número:", 10, 573, 86, 20);
		
		JComboBox rotorIzq = new JComboBox();
		rotorIzq.setBounds(109, 573, 86, 20);
		contentPane.add(rotorIzq);
		
		
	}

	private void createTextField(String string, int i, int j, int k, int l) {
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setText(string);
		textField.setBounds(i, j, 311, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	private void fillRotorComboBox(JComboBox rotor){
		for(int i = 1; i < 9; i++){
			rotor.addItem(i.);
		}
	}
}
