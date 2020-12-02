package logica.naves;

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
		ProyectilEnemigo p = new ProyectilEnemigoBeta(posX,posY+20,35,danio);
		p.setPosY(posY-p.getGrafica().getHeight());
		Juego.getInstance().agregarEntidad(p);
		Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
	}
	
}
