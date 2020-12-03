package logica.proyectil;

import logica.visitor.VisitorProyectilEnemigo;
import logica.movimiento.MovimientoVertical;

public class ProyectilEnemigoGamma extends ProyectilEnemigo{
	
	private static final String [] graficos = new String[] {path+subPath+"/proyectil5.gif"};
	
	public ProyectilEnemigoGamma(int x, int y, int v, int d) {
		super(x, y, v, d,graficos);
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
		setVisitor(new VisitorProyectilEnemigo(this));
		
	}

}


