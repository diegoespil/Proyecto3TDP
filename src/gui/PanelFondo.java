package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

	// Atributo que guardara la imagen de Background que le pasemos.
		private BufferedImage background;
		
		public PanelFondo() {
			try {
				URL url = new URL("/resources/img/fondo.gif");
				background = ImageIO.read(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
		// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
//			/* Obtenemos el tamaño del panel para hacer que se ajuste a este
//			cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
//			int width = this.getSize().width;
//			int height = this.getSize().height;
//	 
//			// Mandamos que pinte la imagen en el panel
//			if (this.background != null) {
//				g.drawImage(this.background, 0, 0, width, height, null);
//			}
//	 
//			super.paintComponent(g);
			g.drawImage(background, 0, 0, null);
		}
		
		 public Dimension getPreferredSize() {
		        if (background == null) {
		             return new Dimension(100,100);
		        } else {
		           return new Dimension(background.getWidth(null), background.getHeight(null));
		       }
		    }
	 
//		// Metodo donde le pasaremos la dirección de la imagen a cargar.
//		public void setBackground(String imagePath) {
//			
//			// Construimos la imagen y se la asignamos al atributo background.
//			//this.setOpaque(false);
//			this.background = new ImageIcon(imagePath).getImage();
//			repaint();
//		}
}
