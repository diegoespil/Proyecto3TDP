package logica.naves;

import logica.arma.Arma;
import logica.entidad.EntidadGrafica;
import logica.movimiento.MovimientoVertical;

public abstract class NaveEnemiga extends Nave{
	
	protected int rango;
	protected int resistenciaDanio;
	protected static final String subPath = "/enemigos";

	public NaveEnemiga(int x, int y, Arma arma, int carga,int rango,int resistencia, String [] graficos) {
		super(x, y, arma, carga, graficos, resistencia);
		this.rango = rango;
		this.resistenciaDanio = resistencia;
		setMovimiento(new MovimientoVertical(this,1));
	}
	
	public int getRango() {
		return this.rango;
	}
	
	public int getResistencia() {
		return this.resistenciaDanio;
	}
	
	
	
}
