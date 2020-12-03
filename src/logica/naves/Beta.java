package logica.naves;

import java.awt.Color;

import javax.swing.BorderFactory;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilEnemigoBeta;

public class Beta extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveBeta.gif",
			path+subPath+"/naveBetaLeft.gif",
			path+subPath+"/naveBetaRight.gif"};
	
	public Beta(int x, int y) {

		super(x, y, 5,graficos,30);
		setVida(100);
		setDanio(30);
	}

	@SuppressWarnings("static-access")
	@Override
	public void disparar() {
		if (contDisparo == 0) {
			//disparar
			ProyectilEnemigo p = new ProyectilEnemigoBeta(posX,posY+20,20,danio);
			p.setPosY(posY-p.getGrafica().getHeight());
			Juego.getInstance().agregarEntidad(p);
			Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
		}
		contDisparo++;
		if (contDisparo >= 5) //Este es el numero que determina cuanto espera para volver a disparar
			contDisparo = 0;
	}
	
}
