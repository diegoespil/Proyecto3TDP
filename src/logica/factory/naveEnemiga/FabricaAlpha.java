package logica.factory.naveEnemiga;

import logica.naves.Alpha;
import logica.naves.NaveEnemiga;

public class FabricaAlpha extends FabricaNaveEnemiga {

	public FabricaAlpha() {
		
	}
	

	@Override
	public NaveEnemiga crearNaveEnemiga() {
		// TODO Auto-generated method stub
		return new Alpha(0, 0);
	}
}
