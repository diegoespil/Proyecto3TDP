package logica.nivel;

import java.util.LinkedList;
import logica.entidad.Entidad;

//Clase que representa el nivel 2 del juego, tiene 3 tandas.
public class Nivel2 extends Nivel {

	public Nivel2() {
		super(3);
	}

	@Override
	public Nivel nextLevel() {
		return null;
	}
	
	//Metodo que devuelve un listado con la tanda de naves enemigas. Si la cantidad de tandas que quedan 
	//es una, entonces sale una tanda especial
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
