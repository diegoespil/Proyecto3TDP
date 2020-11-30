package logica.visitor;

import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public interface Visitor {

	public abstract void visitNaveEnemiga(NaveEnemiga nave);
	
	public abstract void visitNaveJugador(NaveJugador nave);
	
	public abstract void visitProyectilEnemigo(ProyectilEnemigo proyectil);
	
	public abstract void visitProyectilJugador(ProyectilJugador proyectil);

	public abstract void visitPremio(Premio premio);
}
