package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorNaveEnemiga extends Visitor {

	public VisitorNaveEnemiga(Entidad e) {
		super(e);
	}
	
	public void visitNaveInfectada(NaveEnemiga nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {
		this.entidad.golpearJugador(nave);
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
