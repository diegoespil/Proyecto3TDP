package logica.naves;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilEnemigoGamma;

public class Gamma extends NaveEnemiga {
	

	private static final String [] graficos = new String[] {path+subPath+"/naveGamma.gif"};

	public Gamma(int x,int y) {
		super(y, y, 5, graficos,100);
		setVida(250);
		setDanio(35);
	}

	@Override
	public void disparar() {
		if (contDisparo == 0) {
			//disparar
			ProyectilEnemigo p = new ProyectilEnemigoGamma(posX,posY+20,20,danio);
			p.setPosY(posY-p.getGrafica().getHeight());
			Juego.getInstance().agregarEntidad(p);
			Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
		}
		contDisparo++;
		if (contDisparo >= 10) //Este es el numero que determina cuanto espera para volver a disparar
			contDisparo = 0;
		
	}

}
