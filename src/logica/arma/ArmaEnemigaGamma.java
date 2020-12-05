package logica.arma;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilEnemigoGamma;

public class ArmaEnemigaGamma extends ArmaEnemiga{

	public ArmaEnemigaGamma() {
		super(15, 35, 10);
	}

	@Override
	public void disparar(int x, int y) {
		if (contarDisparo == 0) {
			ProyectilEnemigo p = new ProyectilEnemigoGamma(x,y+20,this.velocidad,this.danio);
			p.setPosY(y-p.getGrafica().getHeight());
			Juego.getInstance().agregarEntidad(p);
			Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
		}
		contarDisparo++;
		if (contarDisparo >= retardo_disparo) 
			contarDisparo = 0;
		
	}

}
