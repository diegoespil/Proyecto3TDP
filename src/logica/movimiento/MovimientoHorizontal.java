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
		//this.entidad.getGrafica().actualizar(direccion);
		JLabel lbl = this.entidad.getGrafica().getLabel();
		if (direccion == 1 && lbl.getX()+lbl.getWidth() <= 600)
			lbl.setBounds(lbl.getX() + direccion * this.entidad.getVelocidad(), lbl.getY() , lbl.getWidth(), lbl.getHeight());
		else if (direccion == -1 && lbl.getX() >= 0)
			lbl.setBounds(lbl.getX() + direccion * this.entidad.getVelocidad(), lbl.getY() , lbl.getWidth(), lbl.getHeight());
	}

}
