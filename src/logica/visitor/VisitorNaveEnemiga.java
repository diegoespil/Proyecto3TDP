package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorNaveEnemiga extends Visitor {

	public VisitorNaveEnemiga(NaveEnemiga ne) {
		super(ne);
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {
		NaveEnemiga miNave = (NaveEnemiga) this.entidad;
		nave.setVida( nave.getVida() - miNave.getDanio() );
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
