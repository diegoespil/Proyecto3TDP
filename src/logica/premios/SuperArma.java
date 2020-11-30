package logica.premios;

import logica.naves.NaveJugador;
import logica.visitor.Visitor;

public class SuperArma extends Temporal {
	//esto es hasta que tengamos la imagen.
	protected static final String[] graficos=null;
	//Se podria setear otro tiempo.
	protected static final int tiempo = 10;

	public SuperArma(int x, int y) {
		super(x, y,graficos,tiempo);
	}

	public void accept(Visitor v) {
		v.visitPremio(this);
	}

	@Override
	public void activar(NaveJugador nj) {
	
		
	}


	
}
