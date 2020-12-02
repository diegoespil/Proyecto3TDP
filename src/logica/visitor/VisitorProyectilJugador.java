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
	
	public void visitNaveEnemiga(NaveEnemiga nave) {
		nave.setVida( nave.getVida() - proyectil.getDanio() );
		proyectil.setEnJuego(false);
		//System.out.println("deje al enemigo con "+nave.getVida()+" de vida");
		//System.out.println("El enemigo quedo en juego: "+nave.estaEnJuego());
	}
	
	public void visitNaveJugador(NaveJugador nave) {}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
