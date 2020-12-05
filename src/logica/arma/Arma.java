package logica.arma;

public abstract class Arma {

	protected int danio;
	protected int velocidad;
	
	public Arma(int vel,int danio) {
		this.danio = danio;
		this.velocidad = vel;
	}
	
	public abstract void disparar(int x,int y);
	
	public int getDanio() {
		return this.danio;
	}
	
}
