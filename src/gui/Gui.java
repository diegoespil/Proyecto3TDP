package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;
import logica.naves.NaveJugador;
import java.awt.event.KeyAdapter;
import javax.swing.JProgressBar;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private Mente mente;
	private static Gui instance;
	private JLabel lblPuntaje,lblVida;
	private JProgressBar progressBar;

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
	    
	    incializarLabels(); 
	    
	    contentPane.add(label, JLayeredPane.DEFAULT_LAYER);
	    contentPane.add(lblPuntaje, JLayeredPane.DRAG_LAYER);
		contentPane.add(progressBar,JLayeredPane.DRAG_LAYER);
		contentPane.add(lblVida, JLayeredPane.DRAG_LAYER);
		
		setContentPane(contentPane);
	}
	
	
	
	private void incializarLabels() {
		inicializarPuntos();
		inicializarVida();
	}

	private void inicializarVida() {
		progressBar = new JProgressBar();
		progressBar.setBounds(20, 20, 120, 14);
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(100);
		
		lblVida = new JLabel("100");
		lblVida.setForeground(Color.WHITE);
		lblVida.setFont(new java.awt.Font("Tahoma",1,14));
		lblVida.setBounds(150, 18, 100, 20);
	}

	private void inicializarPuntos() {
		lblPuntaje = new JLabel("Puntos: 0");
	    lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new java.awt.Font("Tahoma", 1, 14));
	    lblPuntaje.setBounds(500, 20, 100, 20);
		
	}

	public static Gui getInstance() {
		return instance;
	}

	public void agregarEntidad(JLabel label) {

		contentPane.add(label, JLayeredPane.DRAG_LAYER);
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
				case KeyEvent.VK_UP: { 	//para testear cuarentena, sacar despues
					Juego.getInstance().activarCuarentena();
					break;
					}
				case KeyEvent.VK_SPACE: {
					jugador.disparar();
					}
				}
				
			}
			
			public void keyReleased(KeyEvent e) {
						jugador.getGrafica().actualizar(0);
						jugador.setPosX((int)jugador.getGrafica().getLabel().getLocation().getX());
			}
		});
		validate();
		repaint();
	}
	
	

	public void actualizarPuntaje() {
		lblPuntaje.setText("Puntos: "+Juego.getInstance().getPuntaje());
	}
	
	public void updateVida(int vida) {
		if (vida <= 25) 
			progressBar.setForeground(Color.RED);
		else 
			if (vida <= 50)
				progressBar.setForeground(Color.YELLOW);
			else 
				if (vida <= 75)
					progressBar.setForeground(Color.ORANGE);
				else progressBar.setForeground(Color.GREEN);
		progressBar.setValue(vida);
		lblVida.setText(""+vida);
	}

	public void gameOver() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/gameOver/gameOver.gif"));
		JLabel lblGameOver = new JLabel(icon,SwingConstants.CENTER);
		lblGameOver.setSize(icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblGameOver, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}

	@SuppressWarnings("static-access")
	public void nextLevel() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/level/levelUp.gif"));
		JLabel lblLevel = new JLabel(icon);
		//lblLevel.setSize(icon.getIconWidth(), icon.getIconHeight());
		lblLevel.setBounds(100, 200, icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblLevel, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
		try {
			mente.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contentPane.remove(lblLevel);
		this.validate();
		this.repaint();
	}

	@SuppressWarnings("deprecation")
	public void win() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/win/win.gif"));
		JLabel lblWin = new JLabel(icon);
		//lblLevel.setSize(icon.getIconWidth(), icon.getIconHeight());
		lblWin.setBounds(200, 100, icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblWin, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
		mente.stop();
		
	}
}
