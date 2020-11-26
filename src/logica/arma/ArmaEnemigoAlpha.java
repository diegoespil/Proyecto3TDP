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
		ProyectilEnemigoAlpha disparo = new ProyectilEnemigoAlpha(x,y,danio);
		disparo.setMovimiento(new MovimientoVertical(disparo, MovimientoVertical.ABAJO));
		return disparo;
	}

}
