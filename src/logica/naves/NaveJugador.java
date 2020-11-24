package logica.naves;

import logica.arma.ArmaJugador;
import logica.entidad.Entidad;
import logica.entidad.EntidadGraficaJugador;
import logica.visitor.Visitor;

public class NaveJugador extends Nave{



	public NaveJugador(int x, int y) {
		//El 15 seria el danio, igual se puede cambiar
		super(x, y, new ArmaJugador(15), 0, new EntidadGraficaJugador());
	}

/*
	public void mover() {
		// TODO Auto-generated method stub
		
	}
*/

	public void accept(Visitor v) {
		v.visitNaveJugador(this);
		
	}

	public void golpearJugador(Entidad j) {}

	public void golpearEnemigo(Entidad e) {
		this.arma.disparar(this.posX, this.posY);
	}

	public void golpearPowerUp(Entidad p) {
	//activar el powerUp
	}

	public void golpearDisparoJugador(Entidad d) {}

	public void golpearDisparoEnemigo(Entidad d) {}

}
