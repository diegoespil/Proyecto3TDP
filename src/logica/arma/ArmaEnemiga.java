package logica.arma;

public abstract class ArmaEnemiga extends Arma {
	
	protected int retardo_disparo;
	protected int contarDisparo;

	public ArmaEnemiga(int vel, int danio,int retardo) {
		super(vel, danio);
		retardo_disparo = retardo;
		contarDisparo = 0;
	}
}
