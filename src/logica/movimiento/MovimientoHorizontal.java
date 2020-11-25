package logica.movimiento;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.entidad.Entidad;
import logica.entidad.EntidadGrafica;

public class MovimientoHorizontal extends Movimiento {

	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	
	public MovimientoHorizontal(Entidad e, int d) {
		super(e, d);
	}
	
	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		//el 5 debería reemplazarse por un getVelocidad()
		lbl.setBounds(lbl.getX() + direccion * 5, lbl.getY() , lbl.getWidth(), lbl.getHeight());
	}

}
