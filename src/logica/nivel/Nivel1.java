package logica.nivel;

import java.util.LinkedList;
import logica.entidad.Entidad;

//Clase que representa el Nivel 1 del juego, se inicia con 3 tandas de enemigos.
public class Nivel1 extends Nivel {

	public Nivel1() {
		super(3);
	}

	@Override
	public Nivel nextLevel() {
		return new Nivel2();
	}

	//Metodo que devuelve un listado con la tanda de naves enemigas. Si la cantidad de tandas que quedan 
	//es una, entonces sale una tanda especial
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
