package graphic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logic.Machine;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JPanel image;
	private File originalFile;
	private File cifratedFile;
	private Machine enigma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 55, 0));
		frame.setBounds(100, 100, 450, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		image = new EnigmaImage(414, 239);
		image.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(image);
		
		JButton btnCifrarMensaje = new JButton("Cifrar mensaje");
		btnCifrarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectFile();
				cifrar();
				saveFile();
				//llamar a cifrador
				//preguntar donde guardarlo
			}
		});
		btnCifrarMensaje.setBackground(SystemColor.activeCaptionBorder);
		btnCifrarMensaje.setFont(new Font("Candara", Font.BOLD, 18));
		btnCifrarMensaje.setBounds(10, 261, 414, 47);
		frame.getContentPane().add(btnCifrarMensaje);
	}

	/**
	 * 
	 */
	protected void saveFile() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	protected void cifrar() {
		SelectRotorsWindow selectRotors = new SelectRotorsWindow(this);
		selectRotors.setVisible(true);
		
		cifratedFile = enigma.cifrate(originalFile);
	}
	
	public void setMachine(Machine machine){
		this.enigma = machine;
	}

	/**
	 * 
	 */
	protected void selectFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("./"));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    originalFile = fileChooser.getSelectedFile();
		}
	}
}
