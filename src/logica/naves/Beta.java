package logica.naves;

public class Beta extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveBeta.gif",
			path+subPath+"/naveBetaLeft.gif",
			path+subPath+"/naveBetaRight.gif"};
	
	public Beta(int x, int y) {

		super(x, y, 5,graficos);
		setVida(100);
		setDanio(30);
	}

	@Override
	public void disparar() {
		
	}
	
}
