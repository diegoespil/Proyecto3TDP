package logica.naves;

import logica.entidad.Entidad;
import logica.proyectil.Proyectil;

public abstract class Nave extends Entidad{

	protected int vida;
	protected int danio;
	
	public Nave(int x, int y, String [] graficos,int vel){
		super(x,y,graficos,vel);
	}
	
	public int getVida() {
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
		if (vida <= 0)
			setEnJuego(false);
	}
	
	public int getDanio() {
		return danio;
	}
	
	public void setDanio(int danio) {
		this.danio = danio;
	}

	public abstract Proyectil disparar();
	
}
