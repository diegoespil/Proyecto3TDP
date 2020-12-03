package logica.nivel;

import java.util.LinkedList;

import logica.entidad.Entidad;
import logica.factory.naveEnemiga.FabricaAlpha;
import logica.factory.naveEnemiga.FabricaBeta;
import logica.factory.naveEnemiga.FabricaGamma;
import logica.factory.naveEnemiga.FabricaNaveEnemiga;
import logica.factory.premio.FabricaCuarentena;
import logica.factory.premio.FabricaPocion;
import logica.factory.premio.FabricaPremio;
import logica.factory.premio.FabricaSuperArma;
import logica.juego.Juego;


public abstract class Nivel {

	protected int enemigos;
	protected FabricaNaveEnemiga fabricaNaveAlpha;
	protected FabricaNaveEnemiga fabricaNaveBeta;
	protected FabricaNaveEnemiga fabricaNaveGamma;
	protected FabricaPremio fabricaSuperArma;
	protected FabricaPremio fabricaCuarentena;
	protected FabricaPremio fabricaPocion;
	
	protected LinkedList<Entidad> premios;
	
	protected int cantidadTandas;
	protected Juego juego;
	
	public Nivel(int enemigos, int cantTandas, Juego juego) {
		this.juego = juego;
		this.enemigos = enemigos;
		this.fabricaNaveAlpha = new FabricaAlpha(this);
		this.fabricaNaveBeta = new FabricaBeta(this);
		this.fabricaNaveGamma = new FabricaGamma(this);
		this.fabricaCuarentena = new FabricaCuarentena(this);
		this.fabricaPocion = new FabricaPocion(this);
		this.fabricaSuperArma = new FabricaSuperArma(this);
		
		this.premios = new LinkedList<Entidad>();
		
		this.cantidadTandas = cantTandas;
	}
	
	public FabricaNaveEnemiga getFabricaNaveAlpha() {
		return this.fabricaNaveAlpha;
	}
	
	public FabricaNaveEnemiga getFabricaNaveBeta() {
		return this.fabricaNaveBeta;
	}
	
	public FabricaNaveEnemiga getFabricaNaveGamma() {
		return this.fabricaNaveGamma;
	}
	
	public FabricaPremio getFabricaCuarentena() {
		return this.fabricaCuarentena;
	}
	
	public FabricaPremio getFabricaPocion() {
		return this.fabricaPocion;
	}
	
	public FabricaPremio getFabricaSuperArma() {
		return this.fabricaSuperArma;
	}
	
	abstract public Nivel nextLevel();
	
	abstract public int getCantidadEnemigos();

	public abstract LinkedList<Entidad> getTanda();

	public Juego getJuego() {
		// TODO Auto-generated method stub
		return juego;
	}
}
