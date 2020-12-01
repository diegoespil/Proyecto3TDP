package logica.visitor;

import logica.juego.Juego;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorRemover implements Visitor{

	public VisitorRemover() {
	}
	
	public void visitNaveEnemiga(NaveEnemiga nave) {
		Juego j = Juego.getInstance();
		j.aumentarPuntaje(nave.getPuntos());
		j.restarEnemigo();
	}
	
	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
