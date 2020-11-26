package logica.naves;

import logica.arma.ArmaEnemigo;
import logica.arma.ArmaEnemigoBeta;
import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.visitor.Visitor;

public class Beta extends NaveEnemiga {

	//Cambiar graficos
	private static final String [] graficos = new String[] {path+subPath+"/naveEnemiga.gif",
			path+subPath+"/naveEnemigaLeft.gif",
			path+subPath+"/naveEnemigaRight.gif"};
	
	public Beta(int x, int y,Juego juego) {
		//Constructor de NaveEnemiga con velocidad 5 y danio 15
		super(x, y, 5,graficos, juego,  new ArmaEnemigoBeta(15));
		setDanio(15);
		setVida(100);
	}
	
}
