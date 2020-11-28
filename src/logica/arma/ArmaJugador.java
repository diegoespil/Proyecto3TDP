package logica.arma;

import logica.movimiento.MovimientoVertical;
import logica.proyectil.Proyectil;
import logica.proyectil.ProyectilJugador;

public class ArmaJugador extends Arma{

	public ArmaJugador(int danio) {
		super(danio);
	}

	public Proyectil disparar(int x, int y) {
		//el parametro null del final es el Juego, que habría que sacar
		ProyectilJugador disparo = new ProyectilJugador(x, y, getVelocidad(), getDanio(), null);
		disparo.setMovimiento(new MovimientoVertical(disparo, MovimientoVertical.ARRIBA));
		return disparo;
	}

}
