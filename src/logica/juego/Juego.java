package logica.juego;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import gui.Gui;
import logica.entidad.Entidad;
import logica.naves.NaveJugador;
import logica.nivel.Nivel;
import logica.nivel.Nivel1;
import logica.visitor.Visitor;
import logica.visitor.VisitorDisparo;
import logica.visitor.VisitorPremioCuarentena;
import logica.visitor.VisitorRemover;

public class Juego {
	
	private Gui gui;
	private Nivel nivel;
	private LinkedList<Entidad> entidades;
	private LinkedList<Entidad> entidadesAEliminar;
	private NaveJugador jugador;
	private boolean gameOver = false;
	private int puntaje = 0;
	private int contadorEnemigos;
	private Visitor visitorRemover, visitorDisparo;
	
	private static Juego instance = null;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private Juego() {
		this.gui = Gui.getInstance();
		System.out.println("Gui "+gui);
		this.nivel = new Nivel1(this);
		this.jugador = new NaveJugador(WIDTH/2, HEIGHT-42);
		this.entidades = new LinkedList<Entidad>();
		this.entidadesAEliminar = new LinkedList<Entidad>();
		agregarJugador();
		contadorEnemigos = 0;
		visitorRemover = new VisitorRemover();
		visitorDisparo = new VisitorDisparo();
//		inicializarEntidades();
		
		//agregarEntidades();
	}
/*	
	lo sacraria a este metodo
	public void setGui(Gui gui) {
		this.gui=gui;
	}
*/	
	public static Juego getInstance() {
		if (instance == null)
			instance = new Juego();
		return instance;
	}

	public void agregarEntidades() {
		for (Entidad e: entidades)
			gui.agregarEntidad(e.getGrafica().getLabel());
		
	}

	private void agregarJugador() {
		Gui.getInstance().agregarEntidad(jugador.getGrafica().getLabel());
		
	}
	
	public void agregarEntidad(Entidad e) {
		entidades.add(e);
	}

	public synchronized void inicializarEntidades() {
		if (nivel != null) {
			LinkedList<Entidad> naves = nivel.getTanda();
			System.out.println("Naves size "+naves.size());
			if (naves != null) {	
				for (Entidad e: naves) {
					entidades.add(e);
					gui.agregarEntidad(e.getGrafica());
					contadorEnemigos++;
				}
			} 
			else {
				nivel = nivel.nextLevel();
			}
		} 
		else {
			gameOver = true;
		}
	}

	public NaveJugador getJugador() {
		return jugador;
	}
	
	public synchronized void detectarColisiones() {

		for (int i = 0; i < entidades.size();i++) {
			Entidad e1 = entidades.get(i);
			hayColision(e1,jugador);
			for (int j= i+1; j< entidades.size();j++) {
				hayColision(e1,entidades.get(j));
			} 
		}
	}

	private void hayColision(Entidad e1, Entidad e2) {
		//System.out.println("Pos x "+e1.getPosX()+"pos y "+e1.getPosY()+"ancho "+e1.getGrafica().getGrafico().getIconWidth()+" alto "+e1.getGrafica().getGrafico().getIconHeight());
		//System.out.println("Pos x "+e2.getPosX()+"pos y "+e2.getPosY()+"ancho "+e2.getGrafica().getGrafico().getIconWidth()+" alto "+e2.getGrafica().getGrafico().getIconHeight());
		Rectangle r1 = new Rectangle(e1.getPosX()+2,e1.getPosY()+2,e1.getGrafica().getGrafico().getIconWidth()-2,e1.getGrafica().getGrafico().getIconHeight()-2);
		Rectangle r2 = new Rectangle(e2.getPosX()+2,e2.getPosY()+2,e2.getGrafica().getGrafico().getIconWidth()-2,e2.getGrafica().getGrafico().getIconHeight()-2);
		if (r1.intersects(r2)) {
			//System.out.println("Colision");
			e1.accept(e2.getVisitor());
			e2.accept(e1.getVisitor());
			Gui.getInstance().actualizarPuntaje();
		}
	}

	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return this.gameOver;
	}
	
	public void GameOver() {
		gameOver = true;
	}

	synchronized public void moverEntidades() {
		// TODO Auto-generated method stub
		for (Entidad e: entidades) {
			e.mover();
		}
	}

	public boolean hayEntidades() {
		// TODO Auto-generated method stub
		return entidades.size()>0;
	}

	public void quitarEntidad(Entidad entidad) {
		entidadesAEliminar.add(entidad);
	}

	public synchronized void dispararEntidades() {
		
		for (int i = 0; i < entidades.size();i++) {
			Entidad e1 = entidades.get(i);
			e1.accept(visitorDisparo);
		}
	}
	
	public synchronized void removerEntidades() {
		for (int i = 0;i<entidades.size();i++) {
			Entidad e = entidades.get(i);
			if (!e.estaEnJuego()) {
				entidadesAEliminar.add(e);
				e.accept(visitorRemover);
			}
		}
		if(!this.jugador.estaEnJuego()) {
			entidadesAEliminar.add(jugador);
			jugador.accept(visitorRemover);
			
		}
		for (Entidad e: entidadesAEliminar) {
			gui.remove(e.getGrafica().getLabel());
			entidades.remove(e);
		}
	}
	
	public synchronized void activarCuarentena() {
		VisitorPremioCuarentena vpc = new VisitorPremioCuarentena();
		//Recorre la lista la primera vez, asignando movimiento nulo
	    for (int i=0; i<entidades.size(); i++) {
			Entidad e = entidades.get(i);
			if (e != null) e.accept(vpc);
		} 
	    TimerTask task = new TimerTask() {
	        public void run() {
	    		//cuando termina la cuarentena, asigna true para que la segunda vuelta
	        	//les devuelva movimiento normal
	    		vpc.setTerminado(true);
	    		for (int i=0; i<entidades.size(); i++) {
	    			Entidad e = entidades.get(i);
	    			if (e != null) e.accept(vpc);
	    		}
	        }
	    };
	    Timer timer = new Timer("Timer");
	    long delay = 5000L;
	    timer.schedule(task, delay);
	}
	
	public void aumentarPuntaje(int p) {
		puntaje+=p;
	}
	
	public void restarEnemigo() {
		contadorEnemigos--;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int getContadorEnemigos() {
		return contadorEnemigos;
	}

}
