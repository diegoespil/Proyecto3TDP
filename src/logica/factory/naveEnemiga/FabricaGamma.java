package logica.factory.naveEnemiga;

import logica.naves.Gamma;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public class FabricaGamma extends FabricaNaveEnemiga {
	
	public FabricaGamma(Nivel n) {
		super(n);
		
	}
	
	//Esta clase representa la creacion de naves enemigas de tipo Gamma
	@Override
	public NaveEnemiga crearNaveEnemiga() {
		Gamma nave = new Gamma(0,0);
		nave.setPowerUp(crearPremio());
		return nave;
	}

}



