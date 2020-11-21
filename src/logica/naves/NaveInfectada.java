package logica.naves;

import logica.arma.Arma;

public abstract class NaveInfectada extends Nave{
	
	protected int rango;
	protected int resistenciaDanio;

	public NaveInfectada(int x, int y, Arma arma, int carga,int rango,int resistencia) {
		super(x, y, arma, carga);
		this.rango = rango;
		this.resistenciaDanio = resistencia;
	}
	
	public int getRango() {
		return this.rango;
	}
	
	public int getResistencia() {
		return this.resistenciaDanio;
	}
	
	
	
}
