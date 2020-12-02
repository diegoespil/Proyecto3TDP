package logica.naves;

import javax.swing.JLabel;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.premios.Premio;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveEnemiga;

public abstract class NaveEnemiga extends Nave{
	
	protected int rango;
	protected static final String subPath = "/enemigos";
	protected int puntos;
	protected Premio powerUp;

	public NaveEnemiga(int x, int y, int vel, String [] graficos, int puntos) {
		super(x, y, graficos, vel);
		setMovimiento(new MovimientoVertical(this,MovimientoVertical.ABAJO));
		setVisitor(new VisitorNaveEnemiga(this));
		this.puntos = puntos;
		rango = 400;
		powerUp = null;
		
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public int getRango() {
		return this.rango;
	}
	
	public Premio getPowerUp() {
		return powerUp;
	}
	
	public void setPowerUp(Premio p) {
		this.powerUp = p;
	}
	
	public void accept(Visitor v) {
		v.visitNaveEnemiga(this);
	}
	
	public void setPosY(int y) {
		this.posY = y;
		if (y >= Juego.HEIGHT) {
			this.posY = 0;
			JLabel lbl = this.getGrafica().getLabel();
			lbl.setBounds(lbl.getX(), 0, lbl.getWidth(), lbl.getHeight());
		}
	}
}
