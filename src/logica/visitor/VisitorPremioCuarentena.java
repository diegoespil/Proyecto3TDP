package logica.visitor;

import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalNulo;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorPremioCuarentena implements Visitor{

	protected boolean terminado;
	
	public VisitorPremioCuarentena() {
		terminado = false;
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {
		//si va a empezar la cuarentena, los detiene
		if (!terminado) {
			nave.setMovimiento(new MovimientoVerticalNulo(nave, MovimientoVerticalNulo.ABAJO));
		}
		else { //si ya hizo la cuarentena, ya termino => hay que devolverles el movimiento normal
			nave.setMovimiento(new MovimientoVertical(nave, MovimientoVertical.ABAJO));
			nave.setVida(nave.getVida());
		}
	}
	
	public void visitNaveJugador(NaveJugador nave) {
		Juego.getInstance().GameOver();
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
	public void setTerminado(boolean t) {
		terminado = t;
	}
}

