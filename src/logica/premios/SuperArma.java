package logica.premios;

import java.util.Timer;
import java.util.TimerTask;

import logica.entidad.Entidad;
import logica.movimiento.MovimientoVertical;
import logica.naves.NaveJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorPremio;
import logica.visitor.VisitorPremioCuarentena;

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
	
		System.out.println("danio original = "+nj.getDanio());
		nj.setDanio(nj.getDanio()+danio_temporal);
		System.out.println("danio durante = "+nj.getDanio());
	    TimerTask task = new TimerTask() {
	        public void run() {
	    		//cuando termina el timepo, le devuelve el danio original
	    		nj.setDanio(nj.getDanio()-danio_temporal);
	    		System.out.println("danio despues = "+nj.getDanio());
	        }
	    };
	    Timer timer = new Timer("Timer");
	    long delay = tiempo;
	    timer.schedule(task, delay);
	}


	
}
