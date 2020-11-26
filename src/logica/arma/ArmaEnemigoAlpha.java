package logica.arma;

import logica.movimiento.MovimientoVertical;
import logica.proyectil.Proyectil;
import logica.proyectil.ProyectilEnemigoAlpha;
import logica.proyectil.ProyectilJugador;

public class ArmaEnemigoAlpha extends ArmaEnemigo {

	public ArmaEnemigoAlpha(int danio) {
		super(danio);
	}

	public Proyectil disparar(int x, int y) {
		//el parametro null del final es el Juego, que habría que sacar
		ProyectilEnemigoAlpha disparo = new ProyectilEnemigoAlpha(x, y, getVelocidad(), getDanio(), null);
		disparo.setMovimiento(new MovimientoVertical(disparo, MovimientoVertical.ABAJO));
		return disparo;
	}

}
