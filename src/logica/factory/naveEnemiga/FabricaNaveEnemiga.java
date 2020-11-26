package logica.factory.naveEnemiga;

import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public abstract class FabricaNaveEnemiga {

	protected Nivel nivel; 
	
	public FabricaNaveEnemiga(Nivel n) {
		this.nivel = n;
	}
	
	abstract public NaveEnemiga crearNaveEnemiga();
}
