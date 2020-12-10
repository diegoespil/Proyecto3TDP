package gui;

import java.awt.EventQueue;

import logica.juego.Juego;

public class Main {

	private static Mente  mente;
	
	public static void main(String[] args) {
		iniciar();
	}

	public static void reiniciarJuego() {
		Juego.getInstance().reiniciar();
	}
	
	@SuppressWarnings("deprecation")
	public static void detenerMente() {
		mente.stop();
	}
	
	public static void reiniciar() {
		Juego juego = Juego.getInstance();
		juego.agregarJugador();
		mente = new Mente();
		mente.start();
	}
	
	public static void iniciar() {
		Gui frame = Gui.getInstance();
		Juego juego = Juego.getInstance();
		juego.agregarJugador();
		frame.iniciarJuego();
		mente = new Mente();
		mente.start();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

