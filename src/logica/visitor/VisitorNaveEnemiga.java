package logica.visitor;

import gui.Gui;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorNaveEnemiga implements Visitor {
	
	protected NaveEnemiga nave;

	public VisitorNaveEnemiga(NaveEnemiga ne) {
		this.nave = ne;
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {}
	
	public void visitNaveJugador(NaveJugador nave) {
		nave.setVida(0);
		Gui.getInstance().updateVida(0);
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
