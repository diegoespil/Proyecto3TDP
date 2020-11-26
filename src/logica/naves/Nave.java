package logica.naves;

import logica.arma.Arma;
import logica.entidad.Entidad;
import logica.entidad.EntidadGrafica;
import logica.juego.Juego;

public abstract class Nave extends Entidad{

	protected Arma arma;
	protected int cargaViral;
	
	public Nave(int x, int y,Arma arma,int carga, String [] graficos,int vel,Juego juego){
		super(x,y,graficos,vel,juego);
		this.arma = arma;
		this.cargaViral = carga;
	}
	
	public int getCargaViral() {
		return this.cargaViral;
	}
	
	public void setCargaViral(int carga) {
		this.cargaViral = carga;
	}
	
	
}
