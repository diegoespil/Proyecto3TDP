package logica.proyectil;

import logica.entidad.Entidad;
import logica.juego.Juego;

public abstract class Proyectil extends Entidad {

	protected int danio;
	
	public Proyectil(int x, int y, int vel, int danio, Juego juego) {
		/*
		 * el null es la EntidadGrafica. Está sí por ahora para que compilen 
		 * los constructores. Debe cambiarse en las clases descendientes (concretas)
		 * cuando se implemente gráficamente.
		 */
		super(x, y, null, vel, juego);
		this.danio = danio;
	}
	
	public int getDanio() {
		return danio;
	}

	
}