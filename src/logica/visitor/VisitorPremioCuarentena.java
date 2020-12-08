package logica.visitor;

import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorPremioCuarentena implements Visitor{

	protected boolean terminado;
	
	public VisitorPremioCuarentena() {
		terminado = false;
	}
	
	//Metodo que le indica a la nave enemiga que debe detenerse
	public void visitNaveEnemiga(NaveEnemiga nave) {
		if (!terminado)
			nave.setDetenido(true);
		else {
			nave.setDetenido(false);
		}
	}
	
	public void visitNaveJugador(NaveJugador nave) {
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
	public void setTerminado(boolean t) {
		terminado = t;
	}
}

