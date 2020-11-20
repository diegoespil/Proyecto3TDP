package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
class Background extends JPanel {
	  private BufferedImage bg;
	  private int yOffset = 0;
	  private int yDelta = 1;

	  public Background() {
	    try {
		      bg = ImageIO.read(this.getClass().getResource("/resources/img/image.jpg"));
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }

	    Timer timer = new Timer(50, new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        yOffset += yDelta;
	        if (yOffset > (getHeight()/2)) {
	          yOffset = 0;
	        }
	        repaint();
	      }
	    });
	    timer.start();
	  }

	  @Override
	  public Dimension getPreferredSize() {
		  System.out.println("getPreferredSize");
	    return new Dimension(bg.getWidth(),bg.getHeight());
	  }

	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawImage(bg, 0, yOffset, null);
	    if (yOffset  == -1) {
	    	g.drawImage(bg, 0, yOffset + getHeight(), null);
	    }
//	    Graphics2D g2d = (Graphics2D) g.create();

//	    int xPos = (getWidth() - bg.getWidth()) / 2;	
//	    int yPos = yOffset;
//
//	    yPos = yOffset;
//	    while (yPos < getHeight()) {
//	      g2d.drawImage(bg, xPos, yPos, this);
//	      yPos += bg.getHeight();
//	    }
//
//	    g2d.dispose();
	  }
	}
