package logica.premios;

import logica.entidad.Entidad;
import logica.visitor.Visitor;

public class Pocion extends Precioso {

	public Pocion(int x, int y) {
		super(x, y);
	}

	public void accept(Visitor v) {
		v.visitPremio(this);	
	}

	public void golpearJugador(Entidad j) {
		
		
	}

	public void golpearEnemigo(Entidad e) {}

	public void golpearPowerUp(Entidad p) {}

	public void golpearDisparoJugador(Entidad d) {}

	public void golpearDisparoEnemigo(Entidad d) {}

	
	
}
