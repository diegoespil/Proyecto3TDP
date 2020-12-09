package logica.naves;

import logica.arma.ArmaEnemigaBeta;

//Clase que representa una nave enemiga, tiene sus graficos, esta nave es mas resistente que la nave Alpha
public class Beta extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveBeta.gif",
			path+subPath+"/naveBetaLeft.gif",
			path+subPath+"/naveBetaRight.gif"};
	
	public Beta(int x, int y) {
		super(x, y, 5,graficos,new ArmaEnemigaBeta(),30,5);
		setVida(100);
	}
}
