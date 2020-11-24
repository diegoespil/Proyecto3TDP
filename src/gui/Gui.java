package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.entidad.Entidad;
import logica.juego.Juego;
import javax.swing.SwingConstants;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JPanel panelFondo;
	private Juego juego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Gui frame = new Gui();
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
	public Gui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(600,650);
		setLocationRelativeTo(null);
		//panelFondo = new ScrollBack();
		//panelFondo.setLayout(null);
		//panelFondo.setBounds(0,0, 600,650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,600,630);
		contentPane.setLayout(null);
		
	    ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/3QAe.gif"));
	    JLabel label = new JLabel(icon);
	    label.setBounds(0,0,600,617);
	    icon.setImageObserver(label);
//	    panelFondo = new JPanel();
//	    panelFondo.setLayout(null);
//	    panelFondo.setBounds(12,12,500,600);
	    contentPane.add(label);

		setContentPane(contentPane);
	    //contentPane.add(panelFondo);
		
//		JPanel panel = new JPanel();
//		panel.setBounds(517, 0, 171, 617);
//		contentPane.add(panel);
//		
		iniciarJuego();
	}

	private void iniciarJuego() {
		juego = new Juego(this);
		JLabel labelJugador = new JLabel();
		labelJugador.setOpaque(true);
		labelJugador.setBounds(300, 549, 31, 42);
		Entidad jugador = juego.getJugador();
		jugador.getGrafica().actualizar(0);
		ImageIcon iconJugador = juego.getJugador().getGrafica().getGrafico();
		labelJugador.setIcon(iconJugador);
		iconJugador.setImageObserver(labelJugador);
		contentPane.add(labelJugador);
		contentPane.validate();
		contentPane.repaint();
	}

}
