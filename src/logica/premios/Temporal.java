package logica.premios;

public abstract class Temporal extends Premio {
	
	protected int tiempo;
	
	public Temporal(int x, int y, int tiempo) {
		super(x, y);
		this.tiempo = tiempo;
	}

}
