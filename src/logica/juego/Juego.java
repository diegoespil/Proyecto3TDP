package logica.juego;

import gui.Gui;
import logica.mapa.Mapa;
import logica.nivel.Nivel;
import logica.nivel.Nivel1;

public class Juego {
	
	private Mapa mapa;
	private Gui gui;
	private Nivel nivel;
	
	public Juego(Gui gui) {
		this.gui = gui;
		this.mapa = new Mapa();
		this.nivel = new Nivel1();
	}

}
