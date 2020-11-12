package logica.naves;

import logica.arma.Arma;
import logica.visitor.Visitor;

public class Alpha extends NaveInfectada {
	
	public Alpha(Arma arma) {
		super(arma);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
	public void duplicarVelocidad() {
		if (this.getVida() < 20)
			this.setVelocidad(this.getVelocidad() * 2);
	}

	

	

}
