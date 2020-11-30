package logica.visitor;

import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorProyectilEnemigo implements Visitor{
	
	protected ProyectilEnemigo proyectil;

	public VisitorProyectilEnemigo(ProyectilEnemigo pe) {
		this.proyectil = pe;
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {
		nave.setVida( nave.getVida() - proyectil.getDanio() );
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}

