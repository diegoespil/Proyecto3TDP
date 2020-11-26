package logica.nivel;

import java.util.LinkedList;
import java.util.Random;

import logica.entidad.Entidad;
import logica.factory.naveEnemiga.FabricaNaveEnemiga;
import logica.factory.premio.FabricaPremio;
import logica.naves.NaveEnemiga;

public class Nivel1 extends Nivel {

	public Nivel1() {
		super(16,4);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Nivel nextLevel() {
		// TODO Auto-generated method stub
		return new Nivel2();
	}

	@Override
	public int getCantidadEnemigos() {
		// TODO Auto-generated method stub
		return this.enemigos;
	}

	public LinkedList<Entidad> getTanda() {
		this.cantidadTandas--;
		Tanda tanda = null;
		if (cantidadTandas >= 0) {
			tanda = new Tanda(4,this);
			return tanda.getTanda();
		} else return null;
	}
	
	public LinkedList<Entidad> getNavesEnemigas(){
		return this.navesEnemigas;
	}
	
}
