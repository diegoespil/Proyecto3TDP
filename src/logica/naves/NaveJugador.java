package logica.naves;

import gui.Gui;
import logica.juego.Juego;
import logica.movimiento.MovimientoHorizontal;
import logica.proyectil.ProyectilJugador;
import logica.visitor.Visitor;
import logica.visitor.VisitorNaveJugador;

public class NaveJugador extends Nave{

	private static final String subPath = "/jugador";
	private static final String [] graficos = new String[] {path+subPath+"/jugador.gif",
			path+subPath+"/jugadorLeft.gif",
			path+subPath+"/jugadorRight.gif"};

	public NaveJugador(int x, int y) {
		super(x, y, graficos,5);
		setMovimiento( new MovimientoHorizontal(this,1) );
		setVisitor(new VisitorNaveJugador(this));
		setVida(100);
		setDanio(15);
	}

	public void accept(Visitor v) {
		v.visitNaveJugador(this);	
	}

	@SuppressWarnings("static-access")
	@Override
	public void disparar() {
		int width = getGrafica().getWidth();
		System.out.println(" pos y "+posY);
		ProyectilJugador p = new ProyectilJugador((posX+width)-(width/2)-5,posY,40,15);
		System.out.println("Height proyectil "+p.getGrafica().getHeight());
		p.setPosY(posY-p.getGrafica().getHeight());
		Juego.getInstance().agregarEntidad(p);
		Gui.getInstance().agregarEntidad(p.getGrafica().getLabel());
	}

}
