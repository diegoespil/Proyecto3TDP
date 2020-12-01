package logica.visitor;

import logica.juego.Juego;
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
	
	public void visitNaveEnemiga(NaveEnemiga nave) {
		nave.setVida( nave.getVida() - proyectil.getDanio() );
		proyectil.setEnJuego(false);
		if (nave.getVida() <= 0) {
			//Juego.getInstance().aumentarPuntaje(nave.getPuntos());
			Juego.getInstance().quitarEntidad(nave);;
		}
	}
	
	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
