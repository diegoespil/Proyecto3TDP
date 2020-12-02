package gui;

import logica.juego.Juego;

public class Mente extends Thread {
	
	private Juego juego;
	
	public Mente() {
		juego = Juego.getInstance();
	}
	
	public void run() {
		while (!juego.isGameOver()) {
			try {
				Thread.sleep(100);
			} catch(Exception e) {
				e.printStackTrace();
			}
			juego.moverEntidades();
			if (!juego.hayEntidades()) {
				System.out.println("No hay entidades");
				juego.inicializarEntidades();
			}
			juego.detectarColisiones();
			juego.dispararEntidades();
			juego.removerEntidades();
		}
	}

}
