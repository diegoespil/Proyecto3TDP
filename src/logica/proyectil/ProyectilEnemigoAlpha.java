package logica.proyectil;

import logica.movimiento.MovimientoVertical;
import logica.visitor.VisitorProyectilEnemigo;

public class ProyectilEnemigoAlpha extends ProyectilEnemigo {
	
	private static final String [] graficos = new String[] {path+subPath+"/proyectil2.gif"};
	
	public ProyectilEnemigoAlpha(int x, int y, int v, int d) {
		super(x, y, v, d,graficos);
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
		setVisitor(new VisitorProyectilEnemigo(this));
		
	}

}
