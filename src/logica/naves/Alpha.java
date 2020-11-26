package logica.naves;

import logica.arma.ArmaEnemigo;
import logica.arma.ArmaEnemigoAlpha;
import logica.entidad.Entidad;
import logica.movimiento.MovimientoHorizontal;
import logica.movimiento.MovimientoVertical;
import logica.visitor.Visitor;

public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveEnemiga.gif",
			path+subPath+"/naveEnemigaLeft.gif",
			path+subPath+"/naveEnemigaRight.gif"};
	
	public Alpha(int x, int y){
		super(x, y, new ArmaEnemigoAlpha(30),100, 10, 5, graficos);
		setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
	}

	/*
	public void mover() {
		// TODO Auto-generated method stub
		
	}
*/
	public void accept(Visitor v) {
		v.visitNaveInfectada(this);
	}
/*	
	public void duplicarVelocidad() {
		if (this.getCargaViral() < 20)
			
			this.setVelocidad(this.getVelocidad() * 2);
			
	}
*/
	public void golpearJugador(Entidad j) {
	//Plantear como atacaria la nave infectada, basicamente verificar el rango
	// y ver si ataca con el arma o directamente te ataca.	
		
	}

	public void golpearEnemigo(Entidad e) {}

	public void golpearPowerUp(Entidad p) {}

	public void golpearDisparoJugador(Entidad d) {}

	public void golpearDisparoEnemigo(Entidad d) {}

}
