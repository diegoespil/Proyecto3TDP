package gui;

import logica.juego.Juego;

public class Mente extends Thread {
	
	private Juego juego;
	
	public Mente(Juego juego) {
		this.juego = juego;
	}
	
	public void run() {
		while (!juego.isGameOver()) {
			try {
				Thread.sleep(200);
			} catch(Exception e) {
				e.printStackTrace();
			}
			juego.moverEntidades();
			if (!juego.hayEntidades()) {
				juego.inicializarEntidades();
			}
			//juego.detectarColisiones();
		}
	}

}
