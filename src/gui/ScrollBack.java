package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ScrollBack extends JPanel implements ActionListener {

	
	private Image image;
	private Timer timer = new Timer(7,this);
	
	private static final int imageWidth = 600;
	private static final int imageHeight = 992;
	private int yStart = 0;
	private int move = 1;
	
	public ScrollBack() {
		ImageIcon icon = new ImageIcon("/resources/img/fondo.png");
		image = icon.getImage();
	}
	
	public void paintComponent(Graphics g) {
		supe
		g.drawImage(image,0,yStart, null);
		if (move == 1)
			g.drawImage(image, 0, yStart+imageHeight, null);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(Math.abs(yStart) == imageHeight)
			yStart = 0;
		else
			yStart+= move;
		repaint();

	}

}
