package logica.factory.premio;

import logica.nivel.Nivel;
import logica.premios.Premio;
import logica.premios.SuperArma;

//Esta clase representa la creacion del powerup SuperArma
public class FabricaSuperArma extends FabricaPremio {

	public FabricaSuperArma(Nivel n) {
		super(n);
	}

	@Override
	public Premio crearPremio() {
		return new SuperArma(0,0);
	}

}
