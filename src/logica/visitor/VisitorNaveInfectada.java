package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveInfectada;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorNaveInfectada extends Visitor {

	
	public VisitorNaveInfectada(Entidad e) {
		super(e);
	}
	
	public void visitNaveInfectada(NaveInfectada nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {
		this.entidad.daniar(nave);
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
