package logica.premios;

import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;

public class SuperArma extends Temporal {
	//esto es hasta que tengamos la imagen.
	protected static final String[] graficos=null;
	//Se podria setear otro tiempo.
	protected static final int tiempo = 10;

	public SuperArma(int x, int y) {
		super(x, y,graficos,tiempo);
		setVisitor(new VisitorPremio(this));
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
	}

	public void accept(Visitor v) {
		v.visitPremio(this);
	}

	@Override
	public void activar(NaveJugador nj) {
	
		
	}


	
}
