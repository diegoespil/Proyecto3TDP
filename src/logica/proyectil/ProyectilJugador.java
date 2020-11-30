package logica.proyectil;

import logica.visitor.Visitor;

public class ProyectilJugador extends Proyectil {
	
	private static final String [] graficos = new String[] {path+subPath+"/proyectil1.gif"};

	public ProyectilJugador(int x, int y, int v, int d) {
		super(x, y, v, d, graficos);
	}

	public void accept(Visitor v) {
		v.visitProyectilJugador(this);	
	}

}
