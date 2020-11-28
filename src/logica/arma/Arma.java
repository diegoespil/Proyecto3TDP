package logica.arma;

import logica.proyectil.Proyectil;

public abstract class Arma {

	protected int danioProyectil;
	protected int velocidadProyectil;
	
	public Arma(int danio) {
		this.danioProyectil = danio;
		
		/*
		 * no necesariamente tiene que ser fija la velocidad, se podría
		 * hacer depender de un parámetro si se quiere
		 */
		this.velocidadProyectil = 20;
	}
	
	public abstract Proyectil disparar(int x,int y);
	
	public int getDanio() {
		return danioProyectil;
	}
	
	public int getVelocidad() {
		return velocidadProyectil;
	}
	
	public void setDanio(int d) {
		danioProyectil = d;
	}
	
	public void setVelocidad(int v) {
		velocidadProyectil = v;
	}

}
