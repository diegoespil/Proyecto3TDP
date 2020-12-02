package logica.movimiento;

import javax.swing.JLabel;
import logica.entidad.Entidad;

public class MovimientoHorizontal extends Movimiento {

	public static final int DERECHA = 1;
	public static final int IZQUIERDA = -1;
	
	public MovimientoHorizontal(Entidad e, int d) {
		super(e, d);
	}
	
	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		if ((direccion == 1 && lbl.getX()+lbl.getWidth() <= 600) || (direccion == -1 && lbl.getX() >= 0)) {
			lbl.setBounds(lbl.getX() + direccion * this.entidad.getVelocidad(), lbl.getY() , lbl.getWidth(), lbl.getHeight());
			this.entidad.setPosX(lbl.getX()+direccion*this.entidad.getVelocidad());
		}
	}

}
