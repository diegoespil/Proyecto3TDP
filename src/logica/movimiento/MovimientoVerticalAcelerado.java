package logica.movimiento;

import javax.swing.JLabel;

import logica.entidad.Entidad;

public class MovimientoVerticalAcelerado extends MovimientoVertical {

	public MovimientoVerticalAcelerado(Entidad e, int d) {
		super(e, d);
	}

	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		//el 5 debería reemplazarse por un getVelocidad()
		lbl.setBounds(lbl.getX(), lbl.getY()  + direccion * 5 * 2, lbl.getWidth(), lbl.getHeight());
	}
}
