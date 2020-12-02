package logica.nivel;

import java.util.LinkedList;

import logica.entidad.Entidad;
import logica.juego.Juego;

public class Nivel2 extends Nivel {

	public Nivel2(Juego juego) {
		super(30, 2,juego);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Nivel nextLevel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCantidadEnemigos() {
		// TODO Auto-generated method stub
		return this.enemigos;
	}

	@Override
	public LinkedList<Entidad> getTanda() {
		// TODO Auto-generated method stub
		this.cantidadTandas--;
		Tanda tanda = null;
		if (cantidadTandas >= 0) {
			tanda = new Tanda(15,this);
			return tanda.getTanda();
		} else 
			return null;
	}

}
