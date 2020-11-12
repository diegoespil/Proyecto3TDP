package logica.naves;

import logica.arma.Arma;

public abstract class NaveInfectada extends Nave{

	private int rango;
	private int resistenciaDanio;
	
	public NaveInfectada(Arma arma) {
		super(arma);
	}
}
