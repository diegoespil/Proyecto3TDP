package logica.movimiento;

import javax.swing.JLabel;

import logica.entidad.Entidad;

public class MovimientoVerticalAcelerado extends MovimientoVertical {

	public MovimientoVerticalAcelerado(Entidad e, int d) {
		super(e, d);
	}

	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		lbl.setBounds(lbl.getX(), lbl.getY()  + direccion * this.entidad.getVelocidad() * 2, lbl.getWidth(), lbl.getHeight());
		this.entidad.setPosY(lbl.getY()+direccion*this.entidad.getVelocidad() * 2);
	}
}
