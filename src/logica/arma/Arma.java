package logica.arma;

public abstract class Arma {

	private int danio;
	
	public Arma(int danio) {
		this.danio = danio;
	}
	
	abstract public void disparar();
}
