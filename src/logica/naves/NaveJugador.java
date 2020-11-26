package logica.naves;

import logica.arma.ArmaJugador;
import logica.entidad.Entidad;
import logica.movimiento.MovimientoHorizontal;
import logica.visitor.Visitor;

public class NaveJugador extends Nave{

	private static final String subPath = "/jugador";
	private static final String [] graficos = new String[] {path+subPath+"/jugador.gif",
			path+subPath+"/jugadorLeft.gif",
			path+subPath+"/jugadorRight.gif"};

	public NaveJugador(int x, int y, int vel) {
		//El 15 seria el danio, igual se puede cambiar
		super(x, y, new ArmaJugador(15), 0, graficos,vel);
		setMovimiento( new MovimientoHorizontal(this,1) );
		//this.getGrafica().actualizar(0);
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
