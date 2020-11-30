package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;

public class ControlJugador implements KeyListener{

	private static Juego juego;
	private Entidad jugador;
	
	public ControlJugador() {
		juego = Juego.getInstance();
		jugador = juego.getJugador();;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("mover izquierda");
			jugador.getMovimiento().setDireccion(MovimientoHorizontal.IZQUIERDA);
			jugador.getGrafica().actualizar(1);
			jugador.mover();
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("mover derecha");
			jugador.getMovimiento().setDireccion(MovimientoHorizontal.DERECHA);
			jugador.getGrafica().actualizar(2);
			jugador.mover();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		jugador.getGrafica().actualizar(0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
