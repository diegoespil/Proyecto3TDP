package logica.naves;

import logica.movimiento.MovimientoVertical;
import logica.movimiento.MovimientoVerticalAcelerado;
import logica.proyectil.Proyectil;


public class Alpha extends NaveEnemiga {

	private static final String [] graficos = new String[] {path+subPath+"/naveAlpha.gif",
			path+subPath+"/naveAlphaLeft.gif",
			path+subPath+"/naveAlphaRight.gif"};
	
	public Alpha(int x, int y){
		super(x, y,5,graficos);
		setVida(50);
		setDanio(15);
	}
	
	@Override
	public void setVida(int vida) {
		this.vida = vida;
		if (getVida() <= 10 && estaEnJuego())
			setMovimiento(new MovimientoVerticalAcelerado(this, MovimientoVertical.ABAJO));
		
	}

	@Override
	public Proyectil disparar() {
		// TODO Auto-generated method stub
		return null;
	}

}
