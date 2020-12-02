package logica.nivel;

import java.util.LinkedList;
import logica.entidad.Entidad;
import logica.juego.Juego;

public class Nivel1 extends Nivel {

	public Nivel1(Juego j) {
		super(16,2,j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Nivel nextLevel() {
		// TODO Auto-generated method stub
		return new Nivel2(this.juego);
	}

	@Override
	public int getCantidadEnemigos() {
		// TODO Auto-generated method stub
		return this.enemigos;
	}

	public LinkedList<Entidad> getTanda() {
		System.out.println("Cantidad de tandas "+cantidadTandas);
		this.cantidadTandas--;
		Tanda tanda = null;
		if (cantidadTandas >= 0) {
			tanda = new Tanda(8,this);
			return tanda.getTanda();
		} else 
			return null;
	}
	
	
	
}
