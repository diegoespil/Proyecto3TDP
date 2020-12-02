package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;
import logica.naves.NaveJugador;
import java.awt.event.KeyAdapter;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private Mente mente;
	private ControlJugador controlJugador;
	private static Gui instance;
	private JLabel lblPuntaje;

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
	private Gui() {
		
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
		instance = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(600,650);
		setLocationRelativeTo(null);
		
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,600,630);
		contentPane.setLayout(null);
		
		iniciarJuego();
		mente = new Mente();
		mente.start();
		
	    ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/fondo/fondo.gif"));
	    JLabel label = new JLabel(icon);
	    label.setBounds(0,0,600,617);
	    icon.setImageObserver(label);
	    
	    lblPuntaje = new JLabel("Puntos: 0");
	    lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new java.awt.Font("Tahoma", 1, 11));
	    lblPuntaje.setBounds(500, 20, 100, 20);
	    
	    contentPane.add(label, JLayeredPane.DEFAULT_LAYER);
	    contentPane.add(lblPuntaje, JLayeredPane.POPUP_LAYER);
	    

		setContentPane(contentPane);
	}
	
	
	
	public static Gui getInstance() {
		return instance;
	}

	public void agregarEntidad(JLabel label) {

		contentPane.add(label, JLayeredPane.POPUP_LAYER);
		this.validate();
		this.repaint();
	}

	private void iniciarJuego() {
		NaveJugador jugador = Juego.getInstance().getJugador();
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch (code) {
				case KeyEvent.VK_LEFT: {
					jugador.getMovimiento().setDireccion(MovimientoHorizontal.IZQUIERDA);
					jugador.getGrafica().actualizar(1);
					jugador.mover();
					break;
					}
				case KeyEvent.VK_RIGHT: {
					jugador.getMovimiento().setDireccion(MovimientoHorizontal.DERECHA);
					jugador.getGrafica().actualizar(2);
					jugador.mover();
					break;
					}
				case KeyEvent.VK_SPACE: {
					jugador.disparar();}
				}
				
			}
			
			public void keyReleased(KeyEvent e) {
						jugador.getGrafica().actualizar(0);
			}
		});
		validate();
		repaint();
	}
	
	public static class ControlJugador implements KeyListener{

		private static Juego juego;
		private Entidad jugador;
		
		public ControlJugador() {
			juego = Juego.getInstance();
			jugador = juego.getJugador();;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("mover izquierda");
				jugador.getMovimiento().setDireccion(MovimientoHorizontal.IZQUIERDA);
				jugador.getGrafica().actualizar(1);
				jugador.mover();
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("mover derecha");
				jugador.getMovimiento().setDireccion(MovimientoHorizontal.DERECHA);
				jugador.getGrafica().actualizar(2);
				jugador.mover();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			jugador.getGrafica().actualizar(0);
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}

	public void actualizarPuntaje() {
		lblPuntaje.setText("Puntos: "+Juego.getInstance().getPuntaje());
	}

	public void gameOver() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/gameOver/gameOver.gif"));
		JLabel lblGameOver = new JLabel(icon,SwingConstants.CENTER);
		lblGameOver.setSize(icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblGameOver, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}
}
