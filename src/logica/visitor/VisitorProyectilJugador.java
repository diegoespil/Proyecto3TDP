package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorProyectilJugador extends Visitor {

	public VisitorProyectilJugador(ProyectilJugador e) {
		super(e);
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {
		ProyectilJugador miProyectil = (ProyectilJugador) this.entidad;
		nave.setVida( nave.getVida() - miProyectil.getDanio() );
	}
	
	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
