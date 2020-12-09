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


//Esta clase representa el Juego y aplica el patron de diseño Singleton. Aqui se crea la NaveJugador, el Nivel, 
//y se mantiene un listado de todas las entidades. Ademas el juego tiene dos Visitor, los cuales son utilizados para que las 
//naves enemigas disparen y otro para eliminar entidades del juego.
public class Juego {

	private Nivel nivel;
	private LinkedList<Entidad> entidades;
	private LinkedList<Entidad> entidadesAEliminar;
	private NaveJugador jugador;
	private boolean gameOver,win;
	private int puntaje = 0;
	private int contadorEnemigos;
	private Visitor visitorRemover, visitorDisparo;
	
	private static Juego instance = null;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	
	private Juego() {
		this.gameOver= false;
		this.win = false;
		this.nivel = new Nivel1();
		this.jugador = new NaveJugador(WIDTH/2, HEIGHT-42);
		this.entidades = new LinkedList<Entidad>();
		this.entidadesAEliminar = new LinkedList<Entidad>();
		contadorEnemigos = 0;
		visitorRemover = new VisitorRemover();
		visitorDisparo = new VisitorDisparo();
	}	

	//Este metodo permite obtener una unica instancia de esta clase
	public static synchronized Juego getInstance() {
		if (instance == null) {
			instance = new Juego();
		}
			
		return instance;
	}
	
	public void reiniciar() {
		instance = null;
	}

	//Metodo para agregar el jugador a la Gui
	public void agregarJugador() {
		Gui.getInstance().agregarEntidad(jugador.getGrafica().getLabel());
	}
	
	//Metodo para agregar una entidad a la lista de entidades
	public void agregarEntidad(Entidad e) {
		entidades.add(e);
	}

	//Metodo para inicializar las entidades del juego, al nivel se le solicita una tanda y se agregan al listado
	//y a la gui. Cuando se termina la tanda, se pasa de nivel, y si no hay mas niveles gana el juego.
	public synchronized void inicializarEntidades() {
		if (nivel != null) {
			LinkedList<Entidad> naves = nivel.getTanda();
			if (naves != null) {	
				for (Entidad e: naves) {
					entidades.add(e);
					Gui.getInstance().agregarEntidad(e.getGrafica());
					contadorEnemigos++;
				}
			} 
			else {
				nivel = nivel.nextLevel();
				if (nivel != null)
					Gui.getInstance().nextLevel();
			}
		} 
		else {
			win = true;
		}
	}

	//Metodo para devolver el jugador del juego
	public NaveJugador getJugador() {
		return jugador;
	}
	
	//Metodo para detectar colisiones entre las entidades que aparecen en el juego
	public synchronized void detectarColisiones() {

		for (int i = 0; i < entidades.size();i++) {
			Entidad e1 = entidades.get(i);
			hayColision(e1,jugador);
			for (int j= i+1; j< entidades.size();j++) {
				hayColision(e1,entidades.get(j));
			} 
		}
	}

	//Metodo que se encarga de verificar si dos entidades colisionan, si colisionan cada una se visita
	//a la otra mediante el metodo accept.
	private void hayColision(Entidad e1, Entidad e2) {
		Rectangle r1 = new Rectangle(e1.getPosX(),e1.getPosY(),32,32);
		Rectangle r2 = new Rectangle(e2.getPosX(),e2.getPosY(),32,32);
		if (r1.intersects(r2)) {
			e1.accept(e2.getVisitor());
			e2.accept(e1.getVisitor());
		}
	}

	//Metodo para retornar si es game over
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	//Metodo que establece game over
	public void GameOver() {
		gameOver = true;
	}

	//Metodo que se encarga de mover las entidades del juego
	public synchronized void moverEntidades() {
		for (int i= 0; i< entidades.size();i++) {
			entidades.get(i).mover();
		}
	}

	//Metodo que devuelve verdades si hay entidades y falso en caso contrario
	public boolean hayEntidades() {
		return entidades.size()>0;
	}

	//Metodo para quitar una entidad del listado, la agrega a un listado auxiliar
	public void quitarEntidad(Entidad entidad) {
		entidadesAEliminar.add(entidad);
	}

	//Metodo para que las entidades disparen, cada entidad del juego acepta el visitor disparo
	public synchronized void dispararEntidades() {
		
		for (int i = 0; i < entidades.size();i++) {
			Entidad e1 = entidades.get(i);
			e1.accept(visitorDisparo);
		}
	}
	
	//Metodo para eliminar entidades. Por cada entidad se consulta si esta en juego, si no lo esta se agrega a un 
	//listado auxiliar de entidades a eliminar, y se le envia el mensaje para que acepte el visitor remover. Para el jugador se 
	//consulta si esta en juego, si no lo esta se agrega al listado, se le envia el mensaje que acepta el visitor remover, y se 
	//avisa a la Gui que actualice la vida. Se recorre el listado de entidades a eliminar y se elimina de la grafica y del listado.
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
			Gui.getInstance().updateVida(0);
		}
		for (Entidad e: entidadesAEliminar) {
			Gui.getInstance().remove(e.getGrafica().getLabel());
			entidades.remove(e);
		}
	}
	
	//Metodo para activar el powerup Cuarentena. Se crea un objeto VisitorCuarentena, se recorre el listado de entidades
	//y se les envia el visitor. Se crea un timer de 5 segundos, el cual pasados los 5 segundos se le avisa al visitor
	//que ya termino la cuarentena, y se vuelve a visitar las entidades con el visitor.
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
		Gui.getInstance().actualizarPuntaje();
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
	
	public boolean winGame() {
		return this.win;
	}

}
