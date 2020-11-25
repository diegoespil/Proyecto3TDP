package logica.arma;

import logica.proyectil.Proyectil;


public abstract class ArmaEnemigo extends Arma{

	public ArmaEnemigo(int danio) {
		super(danio);
	}
	
	public abstract Proyectil disparar(int x, int y);

}
