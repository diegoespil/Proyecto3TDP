package logica.premios;

import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;

public class Pocion extends Precioso {

		protected static final String[] graficos= {"/resources/img/powerUps/pw2.gif"};
	
	public Pocion(int x, int y) {
		super(x, y, graficos);
		setVisitor(new VisitorPremio(this));
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
	}

	public void accept(Visitor v) {
		v.visitPremio(this);	
	}

	@Override
	public void activar(NaveJugador nj) {
		nj.setVida(nj.getVida()+15);	
	}

	

	
	
}
