package logica.naves;

import logica.arma.ArmaEnemigo;
import logica.entidad.Entidad;
import logica.visitor.Visitor;

public class Beta extends NaveEnemiga {

	public Beta(int x, int y) {
		super(x, y, new ArmaEnemigo(15), 100, 5, 10);
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
