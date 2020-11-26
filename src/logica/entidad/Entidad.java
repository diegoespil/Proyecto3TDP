package logica.entidad;

import javax.swing.JComponent;

import logica.juego.Juego;
import logica.movimiento.Movimiento;
import logica.visitor.Visitor;

public abstract class Entidad {

	protected Visitor visitor;
	protected Movimiento mov;
	protected EntidadGrafica entidadGrafica;
	protected int posX;
	protected int posY;
	protected int vida;
	protected int velocidad;
	private Juego juego;

	protected static final String path = "/resources/img";
	
	public Entidad(int x,int y, String [] graficos,int vel, Juego j) {
		this.juego = j;
		this.visitor = null;
		this.posX = x;
		this.posY = y;
		this.entidadGrafica = new EntidadGrafica(graficos,this);
		this.vida = 100;
		this.velocidad = vel;
	}

	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getVida() {
		return vida;
	}
	
	public EntidadGrafica getGrafica() {
		return entidadGrafica;
	}
	
	public Movimiento getMovimiento() {
		return mov;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}

	public void setPosX(int x) {
		this.posX = x;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setVida(int v) {
		vida = v;
	}
	
	public void setJuego(Juego j) {
		this.juego = j;
	}
	
	protected void setVisitor(Visitor v) {
		this.visitor = v;
	}
	
	public void recibirDanio(int danio) {
		this.vida = vida-danio;
	}
	
	public void mover() {
		this.mov.mover();
	}
	
	public void setMovimiento(Movimiento m) {
		mov = m;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public void setVelocidad(int vel) {
		this.velocidad=vel;
	}
	
	public abstract void accept(Visitor v);

	public abstract void golpearJugador(Entidad j);
	
	public abstract void golpearEnemigo(Entidad e);
	
	public abstract void golpearPowerUp(Entidad p);

	public abstract void golpearDisparoJugador(Entidad d);
	
	public abstract void golpearDisparoEnemigo(Entidad d);

	public void morir() {
		this.vida = 0;
		juego.quitarEntidad(this);
	}

}