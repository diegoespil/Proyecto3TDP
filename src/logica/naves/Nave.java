package logica.naves;

import logica.arma.Arma;
import logica.entidad.Entidad;

public abstract class Nave extends Entidad{

	private int vida;
	private Arma arma;
	
	public Nave(Arma arma){
		this.vida = 100;
		this.arma = arma;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
}
