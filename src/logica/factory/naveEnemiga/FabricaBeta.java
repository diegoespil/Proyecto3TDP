package logica.factory.naveEnemiga;

import logica.naves.Beta;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public class FabricaBeta extends FabricaNaveEnemiga {

	public FabricaBeta(Nivel n) {
		super(n);
	}

	@Override
	public NaveEnemiga crearNaveEnemiga() {
		// TODO Auto-generated method stub
		return new Beta(0, 0);
	}
}
