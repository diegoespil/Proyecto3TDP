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
			int posY = (r.nextInt(100)*(-1))*(3);
			int tipoNave = r.nextInt(3)+1;
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
				case 3: {
					ne = nivel.getFabricaNaveGamma().crearNaveEnemiga();
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
