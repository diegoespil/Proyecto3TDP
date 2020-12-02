package logica.premios;

import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;

public class SuperArma extends Temporal {
	
	protected static final String[] graficos= {"/resources/img/powerUps/pw4.gif"};
	protected static final int tiempo = 1000;
	protected static final int danio_temporal = 15;

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
	
		nj.setDanio(nj.getDanio()+danio_temporal);
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		nj.setDanio(nj.getDanio()-danio_temporal);
	}


	
}
