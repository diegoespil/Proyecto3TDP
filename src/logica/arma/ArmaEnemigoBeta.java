package logica.arma;

import logica.movimiento.MovimientoVertical;
import logica.proyectil.Proyectil;
import logica.proyectil.ProyectilEnemigoBeta;

public class ArmaEnemigoBeta extends ArmaEnemigo{

	public ArmaEnemigoBeta(int danio) {
		super(danio);
	}

	public Proyectil disparar(int x, int y) {
		ProyectilEnemigoBeta disparo = new ProyectilEnemigoBeta(x,y,danio);
		disparo.setMovimiento(new MovimientoVertical(disparo, MovimientoVertical.ABAJO));
		return disparo;
	}

}
