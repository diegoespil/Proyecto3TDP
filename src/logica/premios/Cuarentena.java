package logica.premios;

import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;

//Clase que representa el premio Cuarentena, el cual su funcion es inmovilizar a la naves enemigas por un tiempo determinado.
public class Cuarentena extends Temporal {

	protected static final String[] graficos= {"/resources/img/powerUps/pw3.gif"};
	protected static final int tiempo = 5;	
	
	public Cuarentena(int x, int y) {
		super(x, y, graficos, tiempo);
		setVisitor(new VisitorPremio(this));
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
		
	}

	public void accept(Visitor v) {
		v.visitPremio(this);	
	}

	@Override
	public void activar(NaveJugador nj) {
		Juego.getInstance().activarCuarentena();
	}

}
