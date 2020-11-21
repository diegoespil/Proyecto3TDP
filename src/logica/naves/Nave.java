package logica.naves;

import logica.arma.Arma;
import logica.entidad.Entidad;

public abstract class Nave extends Entidad{

	protected Arma arma;
	protected int cargaViral;
	
	public Nave(int x, int y,Arma arma,int carga){
		super(x,y);
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
