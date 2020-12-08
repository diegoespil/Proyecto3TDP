package logica.factory.premio;

import logica.nivel.Nivel;
import logica.premios.Cuarentena;
import logica.premios.Premio;

//Esta clase representa la creacion de powerups de tipo Cuarentena
public class FabricaCuarentena extends FabricaPremio {
	
	public FabricaCuarentena(Nivel n) {
		super(n);
	}

	@Override
	public Premio crearPremio() {
	
		return new Cuarentena(0, 0);
	}

}
