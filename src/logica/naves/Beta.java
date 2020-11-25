package logica.naves;

import logica.arma.ArmaEnemigo;
import logica.arma.ArmaEnemigoBeta;
import logica.entidad.Entidad;
import logica.movimiento.MovimientoVertical;
import logica.visitor.Visitor;

public class Beta extends NaveInfectada {

	public Beta(int x, int y) {
		super(x, y, new ArmaEnemigoBeta(15), 100, 5, 10);
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
	}
	
	/*
	public void mover() {
		// TODO Auto-generated method stub
		
	}
	*/

	public void accept(Visitor v) {
		v.visitNaveInfectada(this);
	}
	
	public void golpearJugador(Entidad j) {
	//Plantear como atacaria la nave infectada, basicamente verificar el rango
	// y ver si ataca con el arma o directamente te ataca.	
		
	}

	public void golpearEnemigo(Entidad e) {}

	public void golpearPowerUp(Entidad p) {}

	public void golpearDisparoJugador(Entidad d) {}

	public void golpearDisparoEnemigo(Entidad d) {}
}
