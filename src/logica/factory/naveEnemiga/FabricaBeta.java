package logica.factory.naveEnemiga;

import java.util.Random;
import logica.naves.Beta;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public class FabricaBeta extends FabricaNaveEnemiga {

	public FabricaBeta(Nivel n) {
		super(n);
	}

	@Override
	public NaveEnemiga crearNaveEnemiga() {
		Beta nave = new Beta(0,0);
		Random r = new Random();
		int probabilidad = r.nextInt(101); 
		
		if(probabilidad<=30) {
			if(probabilidad>15) {
				nave.setPowerUp(this.factoryPocion.crearPremio());
			}
			else {
				if(probabilidad>5) {
					nave.setPowerUp(this.factoryArma.crearPremio());
				}
				else {
					nave.setPowerUp(this.factoryCuarentena.crearPremio());
				}
			}
		}
		else {
			nave.setPowerUp(null);
		}

		return nave;
	}

}
