package logica.nivel;

import java.util.LinkedList;
import java.util.Random;
import logica.entidad.Entidad;
import logica.naves.NaveEnemiga;

//Clase que representa una tanda de naves enemigas, que contiene un listado de naves enemigas, 
//una cantidad de naves que va a tener.
public class Tanda {

	protected LinkedList<Entidad> naves;
	protected int cantidad;
	protected Nivel nivel;
	
	public Tanda(int cantidad, Nivel nivel) {
		this.cantidad = cantidad;
		this.naves = new LinkedList<Entidad>();
		this.nivel = nivel;
	}
	
	//Metodo que devuelve un listado de naves enemigas, donde cada nave es creada a partir de un numero aleatorio
	//el nivel se encarga de crear la nave enemiga a partir de la fabrica instanciada. Cada nave se situa en distintas
	//posiciones de manera aleatoria.
	public LinkedList<Entidad> getTanda(){
		
		Random r= new Random();
		for (int i = 0; i< this.cantidad; i++) {
			int posX = r.nextInt(550);
			int posY = (r.nextInt(100)*(-1))*(3);
			int tipoNave = r.nextInt(2)+1;
			NaveEnemiga ne = null;
			switch (tipoNave) {
				case 1: {
					ne = nivel.getFabricaNaveAlpha().crearNaveEnemiga();
					break;
				}
				case 2: {
					ne = nivel.getFabricaNaveBeta().crearNaveEnemiga();
					break;
				}
			}
			ne.setPosX(posX);
			ne.setPosY(posY);
			ne.getGrafica().setBounds(posX, posY, ne.getGrafica().getWidth(), ne.getGrafica().getHeight());
			naves.add((Entidad) ne);
		}
		
		return naves;
	}
}
