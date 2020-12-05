package logica.premios;

import java.util.Timer;
import java.util.TimerTask;

import logica.arma.Arma;
import logica.arma.ArmaSuper;
import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;

public class SuperArma extends Temporal {
	
	protected static final String[] graficos= {"/resources/img/powerUps/pw4.gif"};
	protected static final int tiempo = 5000;
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
	
		Arma aux = nj.getArma();
		nj.setArma(new ArmaSuper(aux.getDanio()*2));
	
	    TimerTask task = new TimerTask() {
	        public void run() {
	        	nj.setArma(aux);
	        }
	    };
	    Timer timer = new Timer("Timer");
	    long delay = tiempo;
	    timer.schedule(task, delay);
	}


	
}
