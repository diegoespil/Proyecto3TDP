package logica.proyectil;

import logica.visitor.Visitor;

public class ProyectilEnemigo extends Proyectil {

	public ProyectilEnemigo(int x, int y, int v, int d) {
		super(x, y, v, d);
	}

	public void accept(Visitor v) {
		v.visitProyectilEnemigo(this);
	}

}