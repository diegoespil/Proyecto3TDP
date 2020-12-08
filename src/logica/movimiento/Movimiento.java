package logica.movimiento;

import logica.entidad.Entidad;

//Clase abstracta que representa el movimiento de las entidades, se aplica el patron de diseño Strategy.
public abstract class Movimiento {
	
	protected int direccion;
	protected Entidad entidad;
	
	public Movimiento(Entidad e, int d)
	{
		this.entidad  = e;
		this.direccion = d;
	}
	
	public int getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(int d)
	{
		this.direccion = d;
	}
	
	public abstract void mover();

}
