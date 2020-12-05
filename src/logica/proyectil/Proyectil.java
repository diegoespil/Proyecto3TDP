package logica.proyectil;

import logica.entidad.Entidad;

public abstract class Proyectil extends Entidad{

	protected int danio;
	protected static final String subPath = "/proyectiles";
	
	public Proyectil(int x, int y, int vel, int danio,String [] graficos) {
		/*
		 * el null es la EntidadGrafica. Est� s� por ahora para que compilen 
		 * los constructores. Debe cambiarse en las clases descendientes (concretas)
		 * cuando se implemente gr�ficamente.
		 */
		super(x, y, graficos, vel);
		this.danio = danio;
	}
	
	public int getDanio() {
		return danio;
	}
	
}