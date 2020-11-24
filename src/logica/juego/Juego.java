package logica.juego;

import java.awt.Rectangle;
import java.util.LinkedList;

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
	private LinkedList<Entidad> entidades;
	private LinkedList<Entidad> entidadesAEliminar;
	private NaveJugador jugador;
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	public Juego(Gui gui) {
		this.gui = gui;
		this.mapa = new Mapa();
		this.nivel = new Nivel1();
		this.jugador = new NaveJugador(WIDTH/2, HEIGHT);
		inicializarEntidades();
	}

	private void inicializarEntidades() {
		// TODO Auto-generated method stub
		
	}

	public NaveJugador getJugador() {
		// TODO Auto-generated method stub
		return jugador;
	}
	
	public void detectarColisiones() {
		
		for (int i = 0; i < entidades.size();i++) {
			Entidad e1 = entidades.get(i);
			hayColision(e1,jugador);
			for (int j= i+1; j< entidades.size();j++) {
				hayColision(e1,entidades.get(j));
			}
		}
	}

	private void hayColision(Entidad e1, Entidad e2) {
		Rectangle r1 = new Rectangle(e1.getPosX()+2,e1.getPosY()+2,e1.getGrafica().getGrafico().getIconWidth()-2,e1.getGrafica().getGrafico().getIconHeight()-2);
		Rectangle r2 = new Rectangle(e2.getPosX()+2,e2.getPosY()+2,e2.getGrafica().getGrafico().getIconWidth()-2,e2.getGrafica().getGrafico().getIconHeight()-2);
		if (r1.intersects(r2)) {
			e1.accept(e2.getVisitor());
			e2.accept(e1.getVisitor());
		}
	}

}
