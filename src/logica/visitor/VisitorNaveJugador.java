package logica.visitor;

import gui.Gui;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorNaveJugador implements Visitor {

	protected NaveJugador nave;
	
	public VisitorNaveJugador(NaveJugador nj) {
		this.nave = nj;
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {
	}

	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}

	public void visitProyectilJugador(ProyectilJugador proyectil) {}
	
	public void visitPremio(Premio premio) {
		premio.activar(nave);
		Gui.getInstance().updateVida(nave.getVida());
		System.out.println("El jugador agarro un premio");
	}
	
}
