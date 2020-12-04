package logica.nivel;

import java.util.LinkedList;
import logica.entidad.Entidad;

public class Nivel2 extends Nivel {

	public Nivel2() {
		super(30, 3);
	}

	@Override
	public Nivel nextLevel() {
		return null;
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
				tanda = new TandaEspecial(5,this);
			}
			else {
				tanda = new Tanda(15,this);
			}
		}
		this.cantidadTandas--;
		return (tanda == null)? null: tanda.getTanda();
	}

}
