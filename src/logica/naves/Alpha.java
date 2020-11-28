package logica.naves;

import logica.arma.ArmaEnemigo;
import logica.arma.ArmaEnemigoAlpha;
import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;
import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalAcelerado;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveEnemiga;

public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveEnemiga.gif",
			path+subPath+"/naveEnemigaLeft.gif",
			path+subPath+"/naveEnemigaRight.gif"};
	
	public Alpha(int x, int y, Juego juego){
		//Constructor de NaveEnemiga con velocidad 5 y danio 30
		super(x, y, 5, graficos, juego, new ArmaEnemigoAlpha(30));
		setDanio(30);
		setVida(50);
	}
	
	//redefine setVida de Nave para incluir chequeo de cuando tiene que duplicar velocidad
	public void setVida(int vida) {
		this.vida = vida;
		if (getVida() <= 10 && estaEnJuego())
			setMovimiento(new MovimientoVerticalAcelerado(this, MovimientoVertical.ABAJO));
		
	}

}
