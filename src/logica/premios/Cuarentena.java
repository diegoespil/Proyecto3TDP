package logica.premios;

import logica.naves.NaveJugador;
import logica.visitor.Visitor;

public class Cuarentena extends Temporal {

	//esto es hasta que tengamos la imagen.
	protected static final String[] graficos=null;
	protected static final int tiempo = 5;	
	
	public Cuarentena(int x, int y) {
		super(x, y, graficos, tiempo);
	}

	public void accept(Visitor v) {
		v.visitPremio(this);	
	}

	@Override
	public void activar(NaveJugador nj) {
		// TODO Auto-generated method stub
		
	}

}
