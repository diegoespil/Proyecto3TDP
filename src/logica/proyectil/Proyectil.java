package logica.proyectil;

import logica.entidad.Entidad;
import logica.juego.Juego;

public abstract class Proyectil extends Entidad {

	protected int danio;
	
	public Proyectil(int x, int y, int vel, int danio, Juego juego) {
		/*
		 * el null es la EntidadGrafica. Est� s� por ahora para que compilen 
		 * los constructores. Debe cambiarse en las clases descendientes (concretas)
		 * cuando se implemente gr�ficamente.
		 */
		super(x, y, null, vel, juego);
		this.danio = danio;
	}
	
	public int getDanio() {
		return danio;
	}

	
}