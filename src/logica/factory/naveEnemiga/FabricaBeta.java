package logica.factory.naveEnemiga;

import logica.naves.Beta;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public class FabricaBeta extends FabricaNaveEnemiga {

	public FabricaBeta(Nivel n) {
		super(n);
	}

	//Esta clase representa la creacion de naves enemigas de tipo Beta
	@Override
	public NaveEnemiga crearNaveEnemiga() {
		Beta nave = new Beta(0,0);
		nave.setPowerUp(crearPremio());
		return nave;
	}

}
