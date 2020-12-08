package logica.nivel;

import java.util.LinkedList;
import java.util.Random;
import logica.entidad.Entidad;
import logica.naves.NaveEnemiga;

//Clase que representa una tanda de naves enemigas, que contiene un listado de naves enemigas, 
//una cantidad de naves que va a tener.
public class TandaEspecial extends Tanda {
	
	public TandaEspecial(int cantidad,Nivel n) {
		super(cantidad,n);
		this.naves = new LinkedList<Entidad>();
	}
	
	//Metodo que devuelve un listado de naves enemigas, donde cada nave es creada a partir de un numero aleatorio
	//el nivel se encarga de crear la nave enemiga a partir de la fabrica de naves de tipo Gamma. Cada nave se situa en distintas
	//posiciones de manera aleatoria.
	public LinkedList<Entidad> getTanda(){
		
		Random r= new Random();
		
		for(int i=0;i<this.cantidad;i++) {
			int posX = r.nextInt(550);
			int posY = (r.nextInt(100)*(-1))*(3);
			NaveEnemiga nave = this.nivel.getFabricaNaveGamma().crearNaveEnemiga();
			nave.setPosX(posX);
			nave.setPosY(posY);
			nave.getGrafica().setBounds(posX, posY, nave.getGrafica().getWidth(), nave.getGrafica().getHeight());
			naves.add(nave);
		}

		return naves;
	}

}
