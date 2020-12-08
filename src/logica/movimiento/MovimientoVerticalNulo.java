package logica.movimiento;

import javax.swing.JLabel;

import logica.entidad.Entidad;

//Este movimiento es utilizado para detener las naves enemigas cuando se agarra el powerup de cuarentena
public class MovimientoVerticalNulo extends MovimientoVertical {

	public MovimientoVerticalNulo(Entidad e, int d) {
		super(e, d);
	}

	//Metodo que deja el label en el mismo lugar en el que estaba, y actualiza la posicion
	public void mover() {
		JLabel lbl = this.entidad.getGrafica().getLabel();
		lbl.setBounds(lbl.getX(), lbl.getY()  + direccion * 0, lbl.getWidth(), lbl.getHeight());
		this.entidad.setPosY(lbl.getY()+direccion*0);
	}
	
}
