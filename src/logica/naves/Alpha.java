package logica.naves;

import logica.arma.ArmaEnemigaAlpha;
import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalAcelerado;

//Clase que representa una nave enemiga, tiene sus graficos, tiene como caracteristica que cuando su vida es menor a 10
//su movimiento se acelera.
public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveAlpha.gif",
			path+subPath+"/naveAlphaLeft.gif",
			path+subPath+"/naveAlphaRight.gif"};
	
	public Alpha(int x, int y){
		super(x, y,5,graficos,new ArmaEnemigaAlpha(),20,5);
		setVida(50);
	}
	
	//Metodo para actualizar la vida, si su vida es menor igual a 10 y esta en juego y no esta detenida
	//su movimiento cambia a movimiento acelerado.
	@Override
	public void setVida(int vida) {
		super.setVida(vida);
		if (getVida() <= 10 && estaEnJuego() && !estaDetenido() )
			setMovimiento(new MovimientoVerticalAcelerado(this, MovimientoVertical.ABAJO));	
	}
}
