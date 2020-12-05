package logica.naves;

import logica.arma.ArmaJugador;
import logica.movimiento.MovimientoHorizontal;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveJugador;

public class NaveJugador extends Nave{

	private static final String subPath = "/jugador";
	private static final String [] graficos = new String[] {path+subPath+"/jugador.gif",
			path+subPath+"/jugadorLeft.gif",
			path+subPath+"/jugadorRight.gif"};

	public NaveJugador(int x, int y) {
		super(x, y, graficos,9,new ArmaJugador(30,15));
		setMovimiento( new MovimientoHorizontal(this,1) );
		setVisitor(new VisitorNaveJugador(this));
		setVida(100);
	}

	public void accept(Visitor v) {
		v.visitNaveJugador(this);	
	}

}
