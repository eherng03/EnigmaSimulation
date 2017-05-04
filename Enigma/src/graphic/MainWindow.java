package graphic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Machine;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private File originalFile;
	private File cifratedFile;
	private String cifratedMessage;
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
		
		JPanel image = new EnigmaImage(414, 239);
		image.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(image);
		
		JButton btnCifrarMensaje = new JButton("Cifrar mensaje");
		btnCifrarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectFile()){
					selectRotors();
				}
			}
		});
		btnCifrarMensaje.setBackground(SystemColor.activeCaptionBorder);
		btnCifrarMensaje.setFont(new Font("Candara", Font.BOLD, 18));
		btnCifrarMensaje.setBounds(10, 261, 195, 47);
		frame.getContentPane().add(btnCifrarMensaje);
		
		JButton button = new JButton("Guardar mensaje");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveFile();
			}
		});
		button.setFont(new Font("Candara", Font.BOLD, 18));
		button.setBackground(SystemColor.activeCaptionBorder);
		button.setBounds(229, 261, 195, 47);
		frame.getContentPane().add(button);
	}

	private void selectRotors() {
		SelectRotorsWindow selectRotors = new SelectRotorsWindow(this);
	}

	/**
	 * 
	 */
	protected void saveFile() {
		String path = "cifratedMessage";
		JFileChooser fileChooser = new JFileChooser();
		int answer = fileChooser.showSaveDialog(null);
		if (answer == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			if(!("").equals(file.getAbsolutePath())){
				path = file.getAbsolutePath();
			}
		}
		try{
			FileWriter fileWritter = new FileWriter(path + ".txt");
		    PrintWriter writer = new PrintWriter(fileWritter);
		    writer.println(cifratedMessage);
		    writer.close();
		    fileWritter.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al escribir en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 
	 */
	public void cifrar() {	
		try {
			cifratedMessage = enigma.cifrate(originalFile);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void setMachine(Machine machine){
		this.enigma = machine;
	}

	/**
	 * 
	 */
	private boolean selectFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("./"));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    originalFile = fileChooser.getSelectedFile();
		}else{
			return false;
		}
		return true;
	}
}
