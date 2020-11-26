package logica.naves;

import logica.arma.ArmaEnemigo;
import logica.arma.ArmaEnemigoBeta;
import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.visitor.Visitor;

public class Beta extends NaveEnemiga {

	//Cambiar graficos
	private static final String [] graficos = new String[] {path+subPath+"/naveEnemiga.gif",
			path+subPath+"/naveEnemigaLeft.gif",
			path+subPath+"/naveEnemigaRight.gif"};
	
	public Beta(int x, int y,Juego juego) {
		super(x, y, new ArmaEnemigoBeta(15), 100, 5, 10,graficos, juego);
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
