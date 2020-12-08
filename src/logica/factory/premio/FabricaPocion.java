package logica.factory.premio;

import logica.nivel.Nivel;
import logica.premios.Pocion;
import logica.premios.Premio;

//Esta clase representa la creacion de powerups de tipo Pocion
public class FabricaPocion extends FabricaPremio {

	public FabricaPocion(Nivel n) {
		super(n);
	}

	@Override
	public Premio crearPremio() {
		return new Pocion(0,0);
	}

}
