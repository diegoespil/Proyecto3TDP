package logica.proyectil;

import logica.movimiento.MovimientoVertical;
import logica.visitor.Visitor;
import logica.visitor.VisitorProyectilJugador;

public class ProyectilJugador extends Proyectil {
	
	private static final String [] graficos = new String[] {path+subPath+"/proyectil1.gif"};

	public ProyectilJugador(int x, int y, int v, int d) {
		super(x, y, v, d, graficos);
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ARRIBA));
		setVisitor(new VisitorProyectilJugador(this));
	}

	public void accept(Visitor v) {
		v.visitProyectilJugador(this);	
	}

	public void setPosY(int y) {
		this.posY = y;
		if (y <= 0) setEnJuego(false);
	}
	
}
