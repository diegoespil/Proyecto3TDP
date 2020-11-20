package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveInfectada;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorPremio extends Visitor {

	public VisitorPremio(Entidad e) {
		super(e);
	}
	
	public void visitNaveInfectada(NaveInfectada nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}

	public void visitProyectilJugador(ProyectilJugador proyectil) {}
	
	public void visitPremio(Premio premio) {}
	
}
