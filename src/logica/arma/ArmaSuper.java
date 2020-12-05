package logica.arma;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilJugador;

public class ArmaSuper extends ArmaJugador {
	
	public ArmaSuper(int danio) {
		super(20,danio);
	}
	
	public void disparar(int x,int y) {
		ProyectilJugador p = new ProyectilJugador(x,y,this.velocidad,this.danio);
		p.getGrafica().actualizar(1);
		//p.setPosX(x+1);
		p.setPosY(y-p.getGrafica().getHeight());
		p.getGrafica().setBounds(p.getPosX(),p.getPosY(), p.getGrafica().getWidth(), p.getGrafica().getHeight());
		Juego.getInstance().agregarEntidad(p);
		Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
	}

	
}
