package logica.visitor;

import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorPremio implements Visitor {

	protected Premio premio;
	
	public VisitorPremio(Premio p) {
		this.premio = p;
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {
		premio.setEnJuego(false);
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}

	public void visitProyectilJugador(ProyectilJugador proyectil) {}
	
	public void visitPremio(Premio premio) {}
	
}
