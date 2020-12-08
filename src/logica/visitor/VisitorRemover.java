package logica.visitor;

import javax.swing.JLabel;

import gui.Gui;
import logica.juego.Juego;
import logica.naves.NaveEnemiga;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.ProyectilEnemigo;
import logica.proyectil.ProyectilJugador;

public class VisitorRemover implements Visitor{

	public VisitorRemover() {
	}
	
	//Metodo que aumenta el puntaje cuando una nave enemiga muere, y suelta el powerup en su posicion
	public void visitNaveEnemiga(NaveEnemiga nave) {
		Juego j = Juego.getInstance();
		j.aumentarPuntaje(nave.getPuntos());
		j.restarEnemigo();
		Premio powerUp = nave.getPowerUp();
		if(powerUp!= null) {
			powerUp.setPosX(nave.getPosX());
			powerUp.setPosY(nave.getPosY());
			JLabel lbl = powerUp.getGrafica().getLabel();
			lbl.setBounds(powerUp.getPosX(), powerUp.getPosY(), lbl.getWidth(), lbl.getHeight());
			j.agregarEntidad(nave.getPowerUp());
			Gui.getInstance().agregarEntidad(powerUp.getGrafica().getLabel());
		}	
	}
	
	//Metodo que indica que perdio el juego si el jugador esta muerto
	public void visitNaveJugador(NaveJugador nave) {
		Juego.getInstance().GameOver();
	}
	
	public void visitProyectilEnemigo(ProyectilEnemigo proyectil) {}
	
    public void visitProyectilJugador(ProyectilJugador proyectil) {}

	public void visitPremio(Premio premio) {}
	
}
