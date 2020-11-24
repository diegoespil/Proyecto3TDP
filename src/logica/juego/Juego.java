package logica.juego;

import gui.Gui;
import logica.entidad.Entidad;
import logica.mapa.Mapa;
import logica.naves.NaveJugador;
import logica.nivel.Nivel;
import logica.nivel.Nivel1;

public class Juego {
	
	private Mapa mapa;
	private Gui gui;
	private Nivel nivel;
	private NaveJugador jugador;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	public Juego(Gui gui) {
		this.gui = gui;
		this.mapa = new Mapa();
		this.nivel = new Nivel1();
		this.jugador = new NaveJugador(WIDTH/2, HEIGHT);
	}

	public NaveJugador getJugador() {
		// TODO Auto-generated method stub
		return jugador;
	}

}
