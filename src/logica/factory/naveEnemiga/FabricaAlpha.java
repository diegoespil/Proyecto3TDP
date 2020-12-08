package logica.factory.naveEnemiga;

import logica.naves.Alpha;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

//Esta clase representa la creacion de naves enemigas de tipo Alpha
public class FabricaAlpha extends FabricaNaveEnemiga {

	public FabricaAlpha(Nivel n) {
		super(n);
	}
	

	@Override
	public NaveEnemiga crearNaveEnemiga() {
		
		Alpha nave = new Alpha(0,0);
		nave.setPowerUp(crearPremio());
		return nave;
	}

}
