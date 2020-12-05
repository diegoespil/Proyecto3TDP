package logica.arma;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilEnemigoBeta;

public class ArmaEnemigaBeta extends ArmaEnemiga{

	public ArmaEnemigaBeta() {
		super(20, 30, 5);
	}

	@Override
	public void disparar(int x, int y) {
		if (contarDisparo == 0) {
			ProyectilEnemigo p = new ProyectilEnemigoBeta(x,y+20,this.velocidad,this.danio);
			p.setPosY(y-p.getGrafica().getHeight());
			Juego.getInstance().agregarEntidad(p);
			Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
		}
		contarDisparo++;
		if (contarDisparo >= retardo_disparo) 
			contarDisparo = 0;
	}

}
