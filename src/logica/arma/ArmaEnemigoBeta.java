package logica.arma;

import logica.movimiento.MovimientoVertical;
import logica.proyectil.Proyectil;
import logica.proyectil.ProyectilEnemigoAlpha;
import logica.proyectil.ProyectilEnemigoBeta;

public class ArmaEnemigoBeta extends ArmaEnemigo{

	public ArmaEnemigoBeta(int danio) {
		super(danio);
	}

	public Proyectil disparar(int x, int y) {
		//el parametro null del final es el Juego, que habría que sacar
		ProyectilEnemigoBeta disparo = new ProyectilEnemigoBeta(x, y, getVelocidad(), getDanio(), null);
		disparo.setMovimiento(new MovimientoVertical(disparo, MovimientoVertical.ABAJO));
		return disparo;
	}

}
