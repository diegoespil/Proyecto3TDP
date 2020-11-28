package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;
import logica.naves.NaveJugador;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;

public class Gui extends JFrame {


	private JLayeredPane contentPane;
	private Juego juego;
	private Mente mente;
//	private JLabel fondo;

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
		
//Segunda opcion para iniciar la gui
//		fondo = new JLabel();
//		fondo.setIcon(new ImageIcon(Gui.class.getResource("/resources/img/fondo/fondo.gif")));
//		fondo.setBounds(0,0,600,617);
//		fondo.setLayout(null);
//		setContentPane(fondo);
//		iniciarJuego();
//		mente = new Mente(juego);
//		mente.start();
//	    pack();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
//		setSize(600,650);
//		setLocationRelativeTo(null);
//=======
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(600,650);
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,600,630);
		contentPane.setLayout(null);
		
		iniciarJuego();
		mente = new Mente(juego);
		mente.start();
		
	    ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/fondo.gif"));
	    JLabel label = new JLabel(icon);
	    label.setBounds(0,0,600,617);
	    icon.setImageObserver(label);
	    
	    contentPane.add(label, JLayeredPane.DEFAULT_LAYER);

		setContentPane(contentPane);
		
		
	}
	
	

	public void agregarEntidad(JLabel label) {
		
//Segunda opcion para agregar entidades
//		fondo.add(label);
//=======
		contentPane.add(label, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}

	private void iniciarJuego() {
		juego = new Juego(this);
		NaveJugador jugador = juego.getJugador();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jugador.getMovimiento().setDireccion(MovimientoHorizontal.IZQUIERDA);
					jugador.getGrafica().actualizar(1);
					jugador.mover();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jugador.getMovimiento().setDireccion(MovimientoHorizontal.DERECHA);
					jugador.getGrafica().actualizar(2);
					jugador.mover();
				}
			}
			
			public void keyReleased(KeyEvent e) {
						jugador.getGrafica().actualizar(0);
			}
		});
		validate();
		repaint();
	}

}
