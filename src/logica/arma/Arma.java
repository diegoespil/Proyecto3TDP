package logica.arma;

import logica.proyectil.Proyectil;

public abstract class Arma {

	protected int danio;
	
	public Arma(int danio) {
		this.danio = danio;
	}
	
	public abstract Proyectil disparar(int x,int y);
	
	public int getDanio() {
		return danio;
	}

}
