package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveInfectada;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public abstract class Visitor {
	
	protected Entidad entidad;

	public Visitor(Entidad e) {
		this.entidad = e;
	 }
	
	public abstract void visitNaveInfectada(NaveInfectada nave);
	
	public abstract void visitNaveJugador(NaveJugador nave);
	
	public abstract void visitProyectilEnemigo(ProyectilEnemigo proyectil);
	
	public abstract void visitProyectilJugador(ProyectilJugador proyectil);

	public abstract void visitPremio(Premio premio);
}
