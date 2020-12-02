package logica.visitor;

import java.awt.Rectangle;

import logica.juego.Juego;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorDisparo implements Visitor {

	
	public VisitorDisparo() {
	}

	@Override
	public void visitNaveEnemiga(NaveEnemiga nave) {
		
		NaveJugador nave2 = Juego.getInstance().getJugador();
		Rectangle r1 = new Rectangle(nave.getPosX()+2,nave.getPosY()+2,nave.getGrafica().getGrafico().getIconHeight()-2,nave.getRango());
		Rectangle r2 = new Rectangle(nave2.getPosX()+2,nave2.getPosY()+2,nave2.getGrafica().getGrafico().getIconWidth()-2,nave2.getGrafica().getGrafico().getIconHeight()-2);
		if (r1.intersects(r2)) {
			if ( !nave.estaDetenido() )nave.disparar();
		}
		
	}

	public void visitNaveJugador(NaveJugador nave) {}

	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}

	public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}


}
