package logica.premios;

import logica.entidad.Entidad;
import logica.juego.Juego;
import logica.naves.NaveJugador;

public abstract class Premio extends Entidad {

	public Premio(int x, int y,String[] graficos) {
		super(x, y,graficos,5);
	}
	
	public abstract void activar(NaveJugador nj);

	public void setPosY(int y) {
		this.posY = y;
		if (y >= Juego.HEIGHT) {
			this.setEnJuego(false);
		}
	}
}
