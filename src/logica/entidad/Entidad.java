package logica.entidad;

import logica.juego.Juego;
import logica.movimiento.Movimiento;
import logica.visitor.Visitor;

//Esta clase representa una Entidad abstracta del juego, la cual va a tener una posicion, una velocidad, una EntidadGrafica para
//representarla graficamente, un Movimiento que va a ser establecido al crear las clases concretas, y un Visitor, el cual 
//me va a facilitar la colision entre distintas entidades del juego.
public abstract class Entidad {

	protected Visitor visitor;
	protected Movimiento mov;
	protected EntidadGrafica entidadGrafica;
	protected int posX;
	protected int posY;
	protected int velocidad;
	protected boolean enJuego;

	protected static final String path = "/resources/img";
	
	public Entidad(int x,int y, String [] graficos,int vel) {
		this.visitor = null;
		this.posX = x;
		this.posY = y;
		this.entidadGrafica = new EntidadGrafica(graficos,this);
		this.velocidad = vel;
		enJuego = true;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public boolean estaEnJuego() {
		return enJuego;
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
	
	public void setEnJuego(boolean esta) {
		this.enJuego = esta;
	}

	protected void setVisitor(Visitor v) {
		this.visitor = v;
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
	
	//Metodo que avisa al juego que debe quitarse la entidad
	public void morir() {
		enJuego = false;
		Juego.getInstance().quitarEntidad(this);
	}

}