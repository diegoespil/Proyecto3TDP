package logica.entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Esta clase representa toda Entidad de manera grafica en el juego, permite asociarle una imagen a cada entidad
public class EntidadGrafica extends JLabel{

	private static final long serialVersionUID = 1L;
	protected String [] graficos;
	protected ImageIcon graficoActual;
	protected Entidad entidad;
	
	public EntidadGrafica(String [] graficos, Entidad entidad) {
		this.graficoActual = new ImageIcon(this.getClass().getResource(graficos[0]));
		this.graficos = graficos;
		this.entidad = entidad;
		this.setBounds(entidad.getPosX(), entidad.getPosY(), graficoActual.getIconWidth(), graficoActual.getIconHeight());
		this.setIcon(graficoActual);
	}
	
	public JLabel getLabel(){
		return this;
	}
	
	public ImageIcon getGrafico() {
		return graficoActual;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.graficoActual = grafico;
	}
	
	//Metodo que permite actualizar la imagen de acuerdo a una direccion
	public void actualizar(int direccion) {
		if(direccion < graficos.length) {
			ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.graficos[direccion]));
			this.graficoActual.setImage(imageIcon.getImage());
			this.setBounds(entidad.getPosX(), entidad.getPosY(), graficoActual.getIconWidth(), graficoActual.getIconHeight());
			this.setIcon(graficoActual);
		}

	}
}
