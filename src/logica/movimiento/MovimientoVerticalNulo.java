package logica.movimiento;

import javax.swing.JLabel;

import logica.entidad.Entidad;

public class MovimientoVerticalNulo extends MovimientoVertical {

	public MovimientoVerticalNulo(Entidad e, int d) {
		super(e, d);
	}

	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		//reemplaza getVelocidad por un 0
		lbl.setBounds(lbl.getX(), lbl.getY()  + direccion * 0, lbl.getWidth(), lbl.getHeight());
		this.entidad.setPosY(lbl.getY()+direccion*0);
	}
	
}
