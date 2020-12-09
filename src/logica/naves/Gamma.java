package logica.naves;

import logica.arma.ArmaEnemigaGamma;


//Clase que representa una nave enemiga, tiene sus graficos, esta nave es la mas resistente de todas.
public class Gamma extends NaveEnemiga {
	

	private static final String [] graficos = new String[] {path+subPath+"/naveGamma.gif"};

	public Gamma(int x,int y) {
		super(x, y, 5, graficos,new ArmaEnemigaGamma(),100,10);
		setVida(250);
	}

}
