package logica.naves;

import javax.swing.JLabel;

import logica.arma.Arma;
import logica.juego.Juego;
import logica.movimiento.MovimientoVertical;
import logica.premios.Premio;
import logica.movimiento.MovimientoVerticalNulo;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveEnemiga;

//Clase abstracta que representa una nave enemiga, tiene rango, un contador de disparos, un premio, y puntos.
public abstract class NaveEnemiga extends Nave{
	
	protected int rango;
	protected int contDisparo;
	protected static final String subPath = "/enemigos";
	protected int puntos;
	protected Premio powerUp;
	protected boolean detenido;

	public NaveEnemiga(int x, int y, int vel, String [] graficos,Arma arma, int puntos, int danio,int retardo) {
		super(x, y, graficos, vel,arma);
		setMovimiento(new MovimientoVertical(this,MovimientoVertical.ABAJO));
		setVisitor(new VisitorNaveEnemiga(this));
		this.puntos = puntos;
		rango = 400;
		contDisparo = 0;
		powerUp = null;
		detenido = false;
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

	public boolean estaDetenido() {
		return detenido;
	}
	
	//Metodo para actualizar si la nave se mueve o no en el juego
	public void setDetenido(boolean det) {
		detenido = det;
		if (detenido == true) 
			this.setMovimiento(new MovimientoVerticalNulo(this, MovimientoVerticalNulo.ABAJO));
		else {
			this.setMovimiento(new MovimientoVertical(this, MovimientoVertical.ABAJO));
			this.setVida(this.getVida());
		}
	}
	
	public void accept(Visitor v) {
		v.visitNaveEnemiga(this);
	}
	
	//Metodo para actualizar la posicion Y en el juego, si se pasa del limite del juego
	//vuelve a aparecer por arriba
	public void setPosY(int y) {
		this.posY = y;
		if (y >= Juego.HEIGHT) {
			this.posY = 0;
			JLabel lbl = this.getGrafica().getLabel();
			lbl.setBounds(lbl.getX(), 0, lbl.getWidth(), lbl.getHeight());
		}
	}
}
