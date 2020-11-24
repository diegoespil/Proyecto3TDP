package logica.entidad;

import logica.visitor.Visitor;

public abstract class Entidad {

	protected Visitor visitor;
	protected EntidadGrafica entidadGrafica;
	protected int posX;
	protected int posY;
	protected int vida;
	
	public Entidad(int x,int y, EntidadGrafica entidadGrafica) {
		this.visitor = null;
		this.entidadGrafica = entidadGrafica;
		this.posX = x;
		this.posY = y;
		this.vida = 100;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public EntidadGrafica getGrafica() {
		return entidadGrafica;
	}
	
	protected Visitor getVisitor() {
		return visitor;
	}

	protected void setPosX(int x) {
		this.posX = x;
	}
	
	protected void setPosY(int y) {
		this.posY = y;
	}
	
	protected void setVisitor(Visitor v) {
		this.visitor = v;
	}
	
	public void recibirDanio(int danio) {
		this.vida = vida-danio;
	}
	
	public abstract void accept(Visitor v);

	public abstract void golpearJugador(Entidad j);
	
	public abstract void golpearEnemigo(Entidad e);
	
	public abstract void golpearPowerUp(Entidad p);

	public abstract void golpearDisparoJugador(Entidad d);
	
	public abstract void golpearDisparoEnemigo(Entidad d);
}