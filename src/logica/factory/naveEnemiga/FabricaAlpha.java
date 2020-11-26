package logica.factory.naveEnemiga;

import logica.naves.Alpha;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public class FabricaAlpha extends FabricaNaveEnemiga {

	public FabricaAlpha(Nivel n) {
		super(n);
	}
	

	@Override
	public NaveEnemiga crearNaveEnemiga() {
		// TODO Auto-generated method stub
		return new Alpha(0, 0, nivel.getJuego());
	}
}
