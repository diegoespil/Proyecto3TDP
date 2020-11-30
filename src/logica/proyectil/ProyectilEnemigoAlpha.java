package logica.proyectil;


public class ProyectilEnemigoAlpha extends ProyectilEnemigo {
	
	private static final String [] graficos = new String[] {path+subPath+"/proyectil1.gif"};
	
	public ProyectilEnemigoAlpha(int x, int y, int v, int d) {
		super(x, y, v, d,graficos);
		//falta implementar su EntidadGrafica
	}

}
