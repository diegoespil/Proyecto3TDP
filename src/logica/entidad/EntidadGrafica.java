package logica.entidad;

import javax.swing.ImageIcon;

public class EntidadGrafica {
	
	protected String [] graficos;
	protected ImageIcon graficoActual;
	
	public EntidadGrafica() {
		
		
	}
	
	public ImageIcon getGrafico() {
		return graficoActual;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.graficoActual = grafico;
	}
}
