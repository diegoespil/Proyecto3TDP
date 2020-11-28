package logica.naves;

import logica.arma.ArmaJugador;
import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveJugador;

public class NaveJugador extends Nave{

	private static final String subPath = "/jugador";
	private static final String [] graficos = new String[] {path+subPath+"/jugador.gif",
			path+subPath+"/jugadorLeft.gif",
			path+subPath+"/jugadorRight.gif"};

	public NaveJugador(int x, int y, int vel,Juego juego) {
		//El 15 seria el danio, igual se puede cambiar
		super(x, y, graficos,vel,juego,  new ArmaJugador(15));
		setMovimiento( new MovimientoHorizontal(this,1) );
		setVisitor(new VisitorNaveJugador(this));
		setDanio(15);
		setVida(100);
	}

	public void accept(Visitor v) {
		v.visitNaveJugador(this);
		
	}

}
