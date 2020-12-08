package logica.visitor;

import gui.Gui;
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
	
	//Metodo que actualiza la vida del jugador cuando colisiona el proyectil de la nave enemiga.
	public void visitNaveJugador(NaveJugador nave) {
		nave.setVida( nave.getVida() - proyectil.getDanio() );
		proyectil.setEnJuego(false);
		Gui.getInstance().updateVida(nave.getVida());
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}

