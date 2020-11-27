package gui;

import java.awt.Color;
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
	private JPanel panelFondo;
	private Juego juego;
	private Mente mente;

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
		contentPane.add(label, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}

	private void iniciarJuego() {
		juego = new Juego(this);
		//JLabel labelJugador = new JLabel();
		//labelJugador.setBounds(300, 549, 31, 42);
		NaveJugador jugador = juego.getJugador();
		//jugador.getGrafica().actualizar(0);
		//JLabel labelJugador = jugador.getGrafica().getLabel();
		//ImageIcon iconJugador = juego.getJugador().getGrafica().getGrafico();
		//labelJugador.setIcon(iconJugador);
		//iconJugador.setImageObserver(labelJugador);
		//contentPane.add(labelJugador);
		
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
		
		this.validate();
		this.repaint();
	}
	
	/*private void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			jugador.getMovimiento().setDireccion(MovimientoHorizontal.IZQUIERDA);
			System.out.println("tecla izq");
			jugador.mover();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jugador.getMovimiento().setDireccion(MovimientoHorizontal.DERECHA);
			jugador.mover();
			System.out.println("tecla der");
		}
		
	}*/

}