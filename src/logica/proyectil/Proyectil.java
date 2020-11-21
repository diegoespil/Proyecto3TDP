package logica.proyectil;

import logica.entidad.Entidad;

public abstract class Proyectil extends Entidad {

	protected int danio;
	
	public Proyectil(int x, int y, int d) {
		super(x,y);
		this.danio = d;
	}
	
	protected int getDanio() {
		return danio;
	}

	
}