package logica.naves;

import logica.arma.Arma;
import logica.entidad.Entidad;
import logica.entidad.EntidadGrafica;
import logica.juego.Juego;

public abstract class Nave extends Entidad{

	protected Arma arma;
	protected int vida; 
	protected int danio;
	
	public Nave(int x, int y, String [] graficos,int vel,Juego juego, Arma arma){
		super(x,y,graficos,vel,juego);
		this.arma = arma;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public int getDanio() {
		return danio;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
		if (vida <= 0) setEnJuego(false);
	}
	
	public void setDanio(int danio) {
		this.danio= danio;
	}
	
}
