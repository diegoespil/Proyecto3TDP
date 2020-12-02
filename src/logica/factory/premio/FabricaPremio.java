package logica.factory.premio;

import logica.nivel.Nivel;
import logica.premios.Premio;

public abstract class FabricaPremio {
	
	protected Nivel nivel;
	
	public FabricaPremio(Nivel n) {
		nivel = n;
	}
	
	abstract public Premio crearPremio();

}
