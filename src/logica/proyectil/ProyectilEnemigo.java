package logica.proyectil;

import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.visitor.Visitor;

public class ProyectilEnemigo extends Proyectil {

	public ProyectilEnemigo(int x, int y, int v, int d, Juego j) {
		super(x, y, v, d, j);
	}

	public void accept(Visitor v) {
		v.visitProyectilEnemigo(this);
	}
	
	public void setPosY(int y) {
		this.posY = y;
		if (y >= Juego.HEIGHT) setEnJuego(false);
	}

}