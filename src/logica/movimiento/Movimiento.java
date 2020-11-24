package logica.movimiento;

import logica.entidad.Entidad;

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
