package logica.premios;

import logica.naves.NaveJugador;
import logica.visitor.Visitor;

public class Pocion extends Precioso {

	//esto es hasta que tengamos la imagen.
		protected static final String[] graficos=null;
	
	public Pocion(int x, int y) {
		super(x, y, graficos);
	}

	public void accept(Visitor v) {
		v.visitPremio(this);	
	}

	//ese 15 seria lo que recupere la pocion
	@Override
	public void activar(NaveJugador nj) {
		nj.setVida(nj.getVida()+15);
		
	}

	

	
	
}
