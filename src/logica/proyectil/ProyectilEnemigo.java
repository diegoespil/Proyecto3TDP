package logica.proyectil;

import logica.entidad.Entidad;
import logica.visitor.Visitor;

public class ProyectilEnemigo extends Proyectil {

	public ProyectilEnemigo(int x, int y, int d) {
		super(x, y, d);
	}

	public void accept(Visitor v) {
		v.visitProyectilEnemigo(this);
	}

	public void golpearJugador(Entidad j) {
		j.recibirDanio(this.danio);
	}

	public void golpearEnemigo(Entidad e) {
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