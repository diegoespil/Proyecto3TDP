package logica.proyectil;

import logica.juego.Juego;
import logica.visitor.Visitor;

public class ProyectilEnemigo extends Proyectil {

	public ProyectilEnemigo(int x, int y, int v, int d,String [] graficos) {
		super(x, y, v, d, graficos);
	}

	public void accept(Visitor v) {
		v.visitProyectilEnemigo(this);
	}
	
	public void setPosY(int y) {
		this.posY = y;
		if (y >= Juego.HEIGHT) setEnJuego(false);
	}

}