package logica.premios;

import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;

public class Cuarentena extends Temporal {

	//esto es hasta que tengamos la imagen.
	protected static final String[] graficos=null;
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
		// TODO Auto-generated method stub
		
	}

}
