package logica.movimiento;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.entidad.Entidad;
import logica.entidad.EntidadGrafica;

public class MovimientoHorizontal extends Movimiento {

	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	
	public MovimientoHorizontal(Entidad e, int d)
	{
		super(e, d);
	}
	
	public void mover()
	{
		JLabel g = this.entidad.getGrafica().getLabel();
		//el 5 debería reemplazarse por un getVelocidad()
		g.setBounds(g.getX() + direccion * 5, g.getY() , g.getWidth(), g.getHeight());
	}

}
