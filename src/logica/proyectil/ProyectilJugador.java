package logica.proyectil;

import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.visitor.Visitor;

public class ProyectilJugador extends Proyectil {

	public ProyectilJugador(int x, int y, int v, int d, Juego j) {
		super(x, y, v, d, j);
	}

	public void accept(Visitor v) {
		v.visitProyectilJugador(this);	
	}

	public void setPosY(int y) {
		this.posY = y;
		if (y <= 0) setEnJuego(false);
	}
	
}
