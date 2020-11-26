package logica.nivel;

import java.util.LinkedList;

import logica.entidad.Entidad;
import logica.juego.Juego;

public class Nivel2 extends Nivel {

	public Nivel2(Juego juego) {
		super(30, 5,juego);
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
		return 0;
	}

	@Override
	public LinkedList<Entidad> getTanda() {
		// TODO Auto-generated method stub
		return null;
	}

}
