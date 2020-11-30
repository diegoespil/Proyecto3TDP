package logica.proyectil;

import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.visitor.Visitor;

public class ProyectilJugador extends Proyectil {
	
	private static final String [] graficos = new String[] {path+subPath+"/proyectil1.gif"};

	public ProyectilJugador(int x, int y, int v, int d, Juego juego) {
		super(x, y, v, d, graficos, juego);
	}

	public void accept(Visitor v) {
		v.visitProyectilJugador(this);	
	}

}
