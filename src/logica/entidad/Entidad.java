package logica.entidad;

import logica.visitor.Visitor;

public abstract class Entidad {

	private Visitor visitor;
	private EntidadGrafica entidadGrafica;
	private int velocidad;
	private int posX;
	private int posY;
	
	public Entidad() {
		
	}
	
	abstract public void mover();
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	protected int getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}
	
	protected void setVelocidad(int i) {
		this.velocidad = i;
	}
	
	abstract public void accept(Visitor v);
}
