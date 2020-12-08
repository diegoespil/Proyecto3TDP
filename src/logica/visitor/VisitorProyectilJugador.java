package logica.visitor;

import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorProyectilJugador implements Visitor {
	
	protected ProyectilJugador proyectil;

	public VisitorProyectilJugador(ProyectilJugador pj) {
		this.proyectil = pj;
	}
	
	//Metodo que actualiza la vida de la nave enemiga al colision con un proyectil del jugador
	public void visitNaveEnemiga(NaveEnemiga nave) {
		nave.setVida( nave.getVida() - proyectil.getDanio() );
		proyectil.setEnJuego(false);
	}
	
	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
