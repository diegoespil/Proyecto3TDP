package logica.naves;

import javax.swing.JLabel;

import logica.arma.Arma;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveEnemiga;

public abstract class NaveEnemiga extends Nave{
	
	protected int rango;
	protected static final String subPath = "/enemigos";

	public NaveEnemiga(int x, int y, int vel, String [] graficos, Juego juego, Arma arma ) {
		super(x, y, graficos, vel, juego, arma);
		setMovimiento(new MovimientoVertical(this,MovimientoVertical.ABAJO));
		setVisitor(new VisitorNaveEnemiga(this));
		/* 
		 * notar que todavía no estamos usando el atributo rango, y no se 
		 * inicialliza en el constructor
		 */
	}
	
	public int getRango() {
		return this.rango;
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
