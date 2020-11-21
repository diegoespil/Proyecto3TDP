package logica.arma;

import logica.proyectil.Proyectil;

public abstract class Arma {

	protected int danio;
	protected Proyectil municion;
	
	public Arma(int danio) {
		this.danio = danio;
		this.municion = null;
	}
	
	abstract public Proyectil disparar(int x,int y);
	
	public int getDanio() {
		return danio;
	}

}
