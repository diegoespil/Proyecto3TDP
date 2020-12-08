package logica.arma;

//Esta clase representa el arma de las naves enemigas, dispone de un contador de disparos, y un retardo
//para asi poder manejar graficamente la accion de disparar
public abstract class ArmaEnemiga extends Arma {
	
	protected int retardo_disparo;
	protected int contarDisparo;

	public ArmaEnemiga(int vel, int danio,int retardo) {
		this.velocidad = vel;
		this.danio = danio;
		retardo_disparo = retardo;
		contarDisparo = 0;
	}
}
