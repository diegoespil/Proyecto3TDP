package logica.arma;

import gui.Gui;
import logica.juego.Juego;
import logica.proyectil.ProyectilJugador;

public class ArmaJugador extends Arma{

	public ArmaJugador(int vel, int danio) {
		super(vel, danio);
	}

	@Override
	public void disparar(int x,int y) {
		ProyectilJugador p = new ProyectilJugador(x,y,this.velocidad,this.danio);
		p.setPosY(y-p.getGrafica().getHeight());
		p.getGrafica().setBounds(x,y, p.getGrafica().getWidth(), p.getGrafica().getHeight());
		Juego.getInstance().agregarEntidad(p);
		Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
	}
}
