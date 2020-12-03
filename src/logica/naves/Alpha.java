package logica.naves;

import java.awt.Color;

import javax.swing.BorderFactory;

import gui.Gui;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalAcelerado;
import logica.proyectil.Proyectil;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilEnemigoAlpha;
import logica.proyectil.ProyectilEnemigoBeta;

public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveAlpha.gif",
			path+subPath+"/naveAlphaLeft.gif",
			path+subPath+"/naveAlphaRight.gif"};
	
	public Alpha(int x, int y){
		super(x, y,5,graficos,20);
		setVida(50);
		setDanio(15);
	}
	
	@Override
	public void setVida(int vida) {
		super.setVida(vida);
		if (getVida() <= 10 && estaEnJuego() && !estaDetenido() )
			setMovimiento(new MovimientoVerticalAcelerado(this, MovimientoVertical.ABAJO));
		
	}
	
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
