package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

//Esta clase se encarga de mostrar graficamente el juego, aplica el patron de diseño Singleton
public class Gui extends JFrame{

	private static Gui frame;
	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane;
	private Mente mente;
	private static Gui instance;
	private JLabel fondo,lblPuntaje,lblVida, lblPlay, lblExit, lblGameOver, lblWin;
	private boolean gameOver = false;
	private boolean win = false;
	private JProgressBar progressBar;
	private KeyAdapter keyAdapter;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					
//					frame = Gui.getInstance();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		
//		iniciarJuego();
//		mente = new Mente();
//		mente.start();
		
	    ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/fondo/fondo.gif"));
	    fondo = new JLabel(icon);
	    fondo.setBounds(0,0,600,617);
	    icon.setImageObserver(fondo);
	    
	    incializarLabels(); 
	    
	    contentPane.add(fondo, JLayeredPane.DEFAULT_LAYER);
		
		setContentPane(contentPane);
	}
	
	public void borrarComponentes() {
		contentPane.removeAll();
		this.validate();
		this.repaint();
	}
	
	private void reInicializar() {
		incializarLabels();
		contentPane.add(fondo, JLayeredPane.DEFAULT_LAYER);
	}
	
	//Metodo para inicializar los labels de puntos y salud
	private void incializarLabels() {
		inicializarPuntos();
		inicializarVida();
		inicializarPlay();
		inicializarExit();
	}

	private void inicializarExit() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/gameOver/exit.png"));
		lblExit = new JLabel(icon);
		lblExit.setBounds(300, 540, icon.getIconWidth(), icon.getIconHeight());
		lblExit.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	private void inicializarPlay() {
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/gameOver/playAgain.png"));
		lblPlay = new JLabel(icon);
		lblPlay.setBounds(100, 500, icon.getIconWidth(), icon.getIconHeight());
		lblPlay.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main.detenerMente();
				borrarComponentes();
				Main.reiniciarJuego();
				Main.reiniciar();
				reInicializar();
				iniciarJuego();
				requestFocus();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	//Metodo para mostrar graficamente la salud del jugador
	private void inicializarVida() {
		progressBar = new JProgressBar();
		progressBar.setBounds(20, 20, 120, 14);
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(100);
		
		lblVida = new JLabel("100");
		lblVida.setForeground(Color.WHITE);
		lblVida.setFont(new java.awt.Font("Tahoma",1,14));
		lblVida.setBounds(150, 18, 100, 20);
		
		contentPane.add(progressBar,JLayeredPane.DRAG_LAYER);
		contentPane.add(lblVida, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}

	//Metodo para mostrar graficamente los puntos del jugador
	private void inicializarPuntos() {
		lblPuntaje = new JLabel("Puntos: 0");
	    lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setFont(new java.awt.Font("Tahoma", 1, 14));
	    lblPuntaje.setBounds(500, 20, 100, 20);

	    contentPane.add(lblPuntaje, JLayeredPane.DRAG_LAYER);
	    this.validate();
		this.repaint();
	}

	//Metodo que retorna la instancia de la clase
	public static Gui getInstance() {
		if (instance == null) {
			instance = new Gui();
		}
			
		return instance;
	}

	//Metodo que agrega y muestra graficamente un label que representa una entidad en el juegp
	public void agregarEntidad(JLabel label) {

		contentPane.add(label, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}

	//Metodo que inicia una instancia de la clase Juego, y ademas agrega un control al jugador
	public void iniciarJuego() {
		NaveJugador jugador = Juego.getInstance().getJugador();
		keyAdapter = new KeyAdapter() {
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
					jugador.getArma().disparar(jugador.getPosX(),jugador.getPosY());
					}
				}
				
			}
			
			public void keyReleased(KeyEvent e) {
						jugador.getGrafica().actualizar(0);
						jugador.setPosX((int)jugador.getGrafica().getLabel().getLocation().getX());
			}
		};
		this.addKeyListener(keyAdapter);
		validate();
		repaint();
	}
	
	
	//Metodo que actualiza el label del puntaje
	public void actualizarPuntaje() {
		lblPuntaje.setText("Puntos: "+Juego.getInstance().getPuntaje());
	}
	
	//Metodo que actualiza la vida del jugador graficamente
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
		this.validate();
		this.repaint();
	}

	//Metodo que indica graficamente que perdio el juego
	public void gameOver() {
		System.out.println("game over");
		this.gameOver = true;
		this.removeKeyListener(keyAdapter);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/gameOver/gameOver.gif"));
		lblGameOver = new JLabel(icon,SwingConstants.CENTER);
		lblGameOver.setSize(icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblGameOver, JLayeredPane.DRAG_LAYER);
		contentPane.add(lblPlay, JLayeredPane.DRAG_LAYER);
		contentPane.add(lblExit, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
	}

	//Metodo que indica graficamente que avanzo de nivel
	@SuppressWarnings("static-access")
	public void nextLevel() {
		this.removeKeyListener(keyAdapter);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/level/levelUp.gif"));
		JLabel lblLevel = new JLabel(icon);
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
		this.addKeyListener(keyAdapter);
		contentPane.remove(lblLevel);
		this.validate();
		this.repaint();
	}

	//Metodo que indica graficamente que gano el juego
	@SuppressWarnings("deprecation")
	public void win() {
		this.win = true;
		this.removeKeyListener(keyAdapter);
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/resources/img/win/win.gif"));
		lblWin = new JLabel(icon);
		lblWin.setBounds(200, 100, icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblWin, JLayeredPane.DRAG_LAYER);
		contentPane.add(lblPlay, JLayeredPane.DRAG_LAYER);
		contentPane.add(lblExit, JLayeredPane.DRAG_LAYER);
		this.validate();
		this.repaint();
		mente.stop();
		
	}
}
