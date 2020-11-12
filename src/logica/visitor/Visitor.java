package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveInfectada;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.Proyectil;

public abstract class Visitor {
	
	protected Entidad entidad;

	public Visitor(Entidad e) {
		this.entidad = e;
	 }
	
	abstract public void visit(NaveInfectada nave);
	
	abstract public void visit(NaveJugador nave);
	
	abstract public void visit(Proyectil proyectil);

	abstract public void visit(Premio premio);
}
