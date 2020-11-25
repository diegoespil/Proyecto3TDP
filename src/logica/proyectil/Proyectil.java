package logica.proyectil;

import logica.entidad.Entidad;

public abstract class Proyectil extends Entidad {

	protected int danio;
	
	public Proyectil(int x, int y, int d) {
		/*
		 * el null es la EntidadGrafica. Est� s� por ahora para que compilen 
		 * los constructores. Debe cambiarse en las clases concretascuando se 
		 * implemente gr�ficamente.
		 */
		super(x,y,null);
		
		setVida(1);
		this.danio = d;
	}
	
	protected int getDanio() {
		return danio;
	}

	
}