package logica.proyectil;

import logica.visitor.Visitor;

public class ProyectilJugador extends Proyectil {

	public ProyectilJugador(int x, int y, int v, int d) {
		super(x, y, v, d);
	}

	public void accept(Visitor v) {
		v.visitProyectilJugador(this);	
	}

}
