package logica.factory.naveEnemiga;

import logica.factory.premio.FabricaCuarentena;
import logica.factory.premio.FabricaPocion;
import logica.factory.premio.FabricaSuperArma;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;

public abstract class FabricaNaveEnemiga {

	protected Nivel nivel; 
	protected FabricaCuarentena factoryCuarentena;
	protected FabricaPocion factoryPocion;
	protected FabricaSuperArma factoryArma;
	
	public FabricaNaveEnemiga(Nivel n) {
		this.nivel = n;
		factoryCuarentena = new FabricaCuarentena(n);
		factoryPocion = new FabricaPocion(n);
		factoryArma = new FabricaSuperArma(n);
	}
	
	public abstract NaveEnemiga crearNaveEnemiga();
	
}
