package logica.entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class EntidadGrafica {
	
	protected String [] graficos;
	protected JLabel label;
	protected ImageIcon graficoActual;
	protected static final String path = "/resources/img";
	
	public EntidadGrafica(String [] graficos) {
		this.graficoActual = new ImageIcon();
		this.graficos = graficos;
		label = new JLabel();
		label.setBounds(300, 549, 31, 42);
	}
	
	public JLabel getLabel(){
		return label;
	}
	
	public ImageIcon getGrafico() {
		return graficoActual;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.graficoActual = grafico;
	}
	
	public void actualizar(int direccion) {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.graficos[direccion]));
		this.graficoActual.setImage(imageIcon.getImage());
	}
}
