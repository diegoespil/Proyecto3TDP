package logica.naves;

import logica.arma.ArmaEnemigaAlpha;
import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalAcelerado;

public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveAlpha.gif",
			path+subPath+"/naveAlphaLeft.gif",
			path+subPath+"/naveAlphaRight.gif"};
	
	public Alpha(int x, int y){
		super(x, y,5,graficos,new ArmaEnemigaAlpha(),20,15,5);
		setVida(50);
	}
	
	@Override
	public void setVida(int vida) {
		super.setVida(vida);
		if (getVida() <= 10 && estaEnJuego() && !estaDetenido() )
			setMovimiento(new MovimientoVerticalAcelerado(this, MovimientoVertical.ABAJO));	
	}
}
