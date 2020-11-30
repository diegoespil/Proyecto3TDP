package logica.premios;

public abstract class Temporal extends Premio {
	
	protected int tiempo;
	
	public Temporal(int x, int y,String[] graficos,int tiempo) {
		super(x, y,graficos);
		this.tiempo = tiempo;
	}

}
