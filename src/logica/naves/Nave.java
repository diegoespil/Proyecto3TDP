package logica.naves;

import logica.arma.Arma;
import logica.entidad.Entidad;

public abstract class Nave extends Entidad{

	protected int vida;
	protected Arma arma;
	
	public Nave(int x, int y, String [] graficos,int vel,Arma arma){
		super(x,y,graficos,vel);
		this.arma = arma;
	}
	
	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
		if (vida <= 0)
			setEnJuego(false);
	}

	public Arma getArma() {
		return this.arma;
	}
	
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
}
