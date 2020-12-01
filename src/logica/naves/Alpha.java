package logica.naves;

import gui.Gui;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalAcelerado;
import logica.proyectil.Proyectil;
import logica.proyectil.ProyectilEnemigoAlpha;

public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveAlpha.gif",
			path+subPath+"/naveAlphaLeft.gif",
			path+subPath+"/naveAlphaRight.gif"};
	
	public Alpha(int x, int y){
		super(x, y,5,graficos);
		setVida(50);
		setDanio(15);
	}
	
	@Override
	public void setVida(int vida) {
		super.setVida(vida);
		if (getVida() <= 10 && estaEnJuego())
			setMovimiento(new MovimientoVerticalAcelerado(this, MovimientoVertical.ABAJO));
		
	}

	@Override
	public void disparar() {
		Proyectil p = new ProyectilEnemigoAlpha(posX+(getGrafica().getWidth()/2),posY+getGrafica().getHeight(),30,50);
		Juego.getInstance().agregarEntidad(p);
		Gui.getInstance().agregarEntidad(p.getGrafica());
		
	}

}
