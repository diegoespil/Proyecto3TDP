package logica.entidad;

import javax.swing.ImageIcon;

public abstract class EntidadGrafica {
	
	protected String [] graficos;
	protected ImageIcon graficoActual;
	protected static final String path = "/resources/img";
	
	public EntidadGrafica(String [] graficos) {
		this.graficoActual = new ImageIcon();
		this.graficos = graficos;
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
