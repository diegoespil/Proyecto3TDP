package logica.factory.naveEnemiga;

import java.util.Random;

import logica.factory.premio.FabricaCuarentena;
import logica.factory.premio.FabricaPocion;
import logica.factory.premio.FabricaSuperArma;
import logica.naves.NaveEnemiga;
import logica.nivel.Nivel;
import logica.premios.Premio;

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
	
	protected Premio crearPremio() {
		Random r = new Random();
		int probabilidad = r.nextInt(101); 		
		if(probabilidad<=30) {
			if(probabilidad>15) {
				return this.factoryPocion.crearPremio();
			}
			else {
				if(probabilidad>5) {
					return this.factoryArma.crearPremio();
				}
				else {
					return this.factoryCuarentena.crearPremio();
				}
			}
		}
		else {
			 return null;
		}
	}
	
}
