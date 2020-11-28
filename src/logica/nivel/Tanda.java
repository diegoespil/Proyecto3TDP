package logica.nivel;

import java.util.LinkedList;
import java.util.Random;

import logica.entidad.Entidad;
import logica.naves.NaveEnemiga;

public class Tanda {

	private LinkedList<Entidad> naves;
	private int cantidad;
	private Nivel nivel;
	
	public Tanda(int cantidad, Nivel nivel) {
		this.cantidad = cantidad;
		this.naves = new LinkedList<Entidad>();
		this.nivel = nivel;
	}
	
	public LinkedList<Entidad> getTanda(){
		
		Random r= new Random();
		for (int i = 0; i< this.cantidad; i++) {
			int posX = r.nextInt(550);
			int posY = r.nextInt(70)*(-1);
			System.out.println("pos x random "+posX);
			System.out.println("pos y random "+posY);
			NaveEnemiga ne = nivel.getFabricaNaveAlpha().crearNaveEnemiga();
			ne.setPosX(posX);
			ne.setPosY(posY);
			ne.getGrafica().setBounds(posX, posY, ne.getGrafica().getWidth(), ne.getGrafica().getHeight());
			naves.add((Entidad) ne);
		}
		
		return naves;
	}
}