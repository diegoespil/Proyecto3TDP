package gui;

import logica.juego.Juego;

public class Mente extends Thread {
	
	private Juego juego;
	private boolean endGame = false;
	
	public Mente() {
		juego = Juego.getInstance();
	}
	
	public void run() {
		while (true) {
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
			if (juego.winGame()) {
				System.out.println("winGame");
				Gui.getInstance().win();
			}
			juego.detectarColisiones();
			juego.dispararEntidades();
			juego.removerEntidades();
			if (juego.isGameOver() && !endGame) {
				endGame = true;
				Gui.getInstance().gameOver();
			}
		}
		
	}

}
