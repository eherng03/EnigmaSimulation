package graphic;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EnigmaImage extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Image mainImage = null;
	    private Image scaledImage = null;
	    private int originalW = 789;
	    private int originalH = 551;
	 
	    public EnigmaImage(int width, int height) {
	        this.setPreferredSize(new Dimension(width, height));
	        mainImage = new ImageIcon("resources/enigma.jpg").getImage();
	        scaledImage = mainImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    }
	 
	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        g2d = (Graphics2D) g2d.create();
	       
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        if (scaledImage == null)
	           
	            g2d.drawImage(mainImage, 0, 0, this);
	        else {
	            g2d.drawImage(scaledImage, 0, 0, this);
	        }
	        g2d.dispose();
	    }

		public int getOriginalW() {
			return originalW;
		}

		public int getOriginalH() {
			return originalH;
		}


}

