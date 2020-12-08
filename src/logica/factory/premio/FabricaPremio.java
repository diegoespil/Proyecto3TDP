package logica.factory.premio;

import logica.nivel.Nivel;
import logica.premios.Premio;

//Esa clase abstracta representa la fabrica de premios
public abstract class FabricaPremio {
	
	protected Nivel nivel;
	
	public FabricaPremio(Nivel n) {
		nivel = n;
	}
	
	//Metodo abstracto que permite crear premios
	abstract public Premio crearPremio();

}
