package logica.factory.naveEnemiga;

import logica.naves.Beta;
import logica.naves.NaveEnemiga;

public class FabricaBeta extends FabricaNaveEnemiga {

	public FabricaBeta() {
		
	}

	@Override
	public NaveEnemiga crearNaveEnemiga() {
		// TODO Auto-generated method stub
		return new Beta(0, 0);
	}
}
