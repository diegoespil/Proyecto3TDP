package logica.arma;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilEnemigoAlpha;

public class ArmaEnemigaAlpha extends ArmaEnemiga {
	
	public ArmaEnemigaAlpha() {
		super(20, 15, 5);
	}

	@Override
	public void disparar(int x,int y) {
		if (contarDisparo == 0) {
			ProyectilEnemigo p = new ProyectilEnemigoAlpha(x,y+20,this.velocidad,this.danio);
			p.setPosY(y-p.getGrafica().getHeight());
			Juego.getInstance().agregarEntidad(p);
			Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
		}
		contarDisparo++;
		if (contarDisparo >= retardo_disparo) 
			contarDisparo = 0;
	}
}
