package logica.proyectil;

import logica.movimiento.MovimientoVertical;
import logica.visitor.VisitorProyectilEnemigo;

public class ProyectilEnemigoBeta extends ProyectilEnemigo {

	private static final String [] graficos = new String[] {path+subPath+"/proyectil4.gif"};
	
	public ProyectilEnemigoBeta(int x, int y, int v, int d) {
		super(x, y, v, d, graficos);
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
		setVisitor(new VisitorProyectilEnemigo(this));
	}
	
}
