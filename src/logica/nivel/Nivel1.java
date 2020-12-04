package logica.nivel;

import java.util.LinkedList;
import logica.entidad.Entidad;

public class Nivel1 extends Nivel {

	public Nivel1() {
		super(16,3);
	}

	@Override
	public Nivel nextLevel() {
		return new Nivel2();
	}

	@Override
	public int getCantidadEnemigos() {
		return this.enemigos;
	}

	@Override
	public LinkedList<Entidad> getTanda() {
		Tanda tanda = null;
		if (cantidadTandas >= 1) {
			
			if(cantidadTandas == 1) {
				tanda = new TandaEspecial(3,this);
			}
			else {
				tanda = new Tanda(8,this);
			}
		}
		this.cantidadTandas--;
		return (tanda == null)? null: tanda.getTanda();
	}
	
	
	
}
