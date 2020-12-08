package logica.arma;

public abstract class Arma {

	protected int danio;
	protected int velocidad;
	
	//Metodo abstracto para que las naves disparen, recibe un x e y que indica la posicion del proyectil
	public abstract void disparar(int x,int y);
	
	//Metodo que devuelve el danio que tiene el arma
	public int getDanio() {
		return this.danio;
	}
	
}
