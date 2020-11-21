package logica.proyectil;

import logica.entidad.Entidad;
import logica.visitor.Visitor;

public class ProyectilJugador extends Proyectil {

	public ProyectilJugador(int x, int y, int d) {
		super(x, y, d);
	}

	public void accept(Visitor v) {
		v.visitProyectilJugador(this);	
	}

	public void golpearJugador(Entidad j) {
		this.vida = 0;
	}

	public void golpearEnemigo(Entidad e) {
		e.recibirDanio(this.danio);
		this.vida = 0;
	}

	public void golpearPowerUp(Entidad p) {
		this.vida = 0;
	}

	public void golpearDisparoJugador(Entidad d) {
		this.vida = 0;
	}

	public void golpearDisparoEnemigo(Entidad d) {
		this.vida = 0;
	}

}
