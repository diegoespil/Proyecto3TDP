package logica.entidad;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica extends JLabel{

	private static final long serialVersionUID = 1L;
	protected String [] graficos;
	//protected JLabel label;
	protected ImageIcon graficoActual;
	protected Entidad entidad;
	
	public EntidadGrafica(String [] graficos, Entidad entidad) {
		this.graficoActual = new ImageIcon(this.getClass().getResource(graficos[0]));
		this.graficos = graficos;
		this.entidad = entidad;
		//actualizar(0);
		//label = new JLabel();
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
	
	public void actualizar(int direccion) {
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(this.graficos[direccion]));
		this.graficoActual.setImage(imageIcon.getImage());
		//System.out.println("Pos x: "+entidad.getPosX()+" pos y "+entidad.getPosY());
		//this.setBounds(entidad.getPosX(), entidad.getPosY(), graficoActual.getIconWidth(), graficoActual.getIconHeight());
		//this.setIcon(graficoActual);
	}
}
