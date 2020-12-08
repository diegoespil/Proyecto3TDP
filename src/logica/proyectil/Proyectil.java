package logica.proyectil;

import logica.entidad.Entidad;

//Clase abstracta que representa un proyectil.
public abstract class Proyectil extends Entidad{

	protected int danio;
	protected static final String subPath = "/proyectiles";
	
	public Proyectil(int x, int y, int vel, int danio,String [] graficos) {
		super(x, y, graficos, vel);
		this.danio = danio;
	}
	
	public int getDanio() {
		return danio;
	}
	
}