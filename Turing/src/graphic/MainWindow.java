package graphic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JPanel image;

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
		
		image = new TuringImage(414, 239);
		image.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(image);
		
		JButton btnCifrarMensaje = new JButton("Descifrar mensaje");
		btnCifrarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//abrir fichero con el mensaje
				//llamar a cifrador
				//preguntar donde guardarlo
			}
		});
		btnCifrarMensaje.setBackground(SystemColor.activeCaptionBorder);
		btnCifrarMensaje.setFont(new Font("Candara", Font.BOLD, 18));
		btnCifrarMensaje.setBounds(10, 261, 414, 47);
		frame.getContentPane().add(btnCifrarMensaje);
	}
}
