package logica.movimiento;

import javax.swing.JLabel;

import logica.entidad.Entidad;

public class MovimientoVertical extends Movimiento {
	
	public static final int ABAJO = 1;
	public static final int ARRIBA = -1;
	
	public MovimientoVertical(Entidad e, int d) {
		super(e, d);
	}
	
	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		//el 5 debería reemplazarse por un getVelocidad()
		lbl.setBounds(lbl.getX(), lbl.getY()  + direccion * 5, lbl.getWidth(), lbl.getHeight());
	}

}
