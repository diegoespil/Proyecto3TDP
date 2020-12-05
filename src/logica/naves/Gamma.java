package logica.naves;

import logica.arma.ArmaEnemigaGamma;

public class Gamma extends NaveEnemiga {
	

	private static final String [] graficos = new String[] {path+subPath+"/naveGamma.gif"};

	public Gamma(int x,int y) {
		super(x, y, 5, graficos,new ArmaEnemigaGamma(),100,35,10);
		setVida(250);
	}

}
