package logica.nivel;

import java.util.LinkedList;

import logica.entidad.Entidad;
import logica.factory.naveEnemiga.FabricaAlpha;
import logica.factory.naveEnemiga.FabricaBeta;
import logica.factory.naveEnemiga.FabricaNaveEnemiga;
import logica.factory.premio.FabricaCuarentena;
import logica.factory.premio.FabricaPocion;
import logica.factory.premio.FabricaPrecioso;
import logica.factory.premio.FabricaPremio;
import logica.factory.premio.FabricaSuperArma;
import logica.factory.premio.FabricaTemporal;
import logica.naves.NaveEnemiga;

public abstract class Nivel {

	protected int enemigos;
	protected FabricaNaveEnemiga fabricaNaveAlpha;
	protected FabricaNaveEnemiga fabricaNaveBeta;
	protected FabricaPremio fabricaSuperArma;
	protected FabricaPremio fabricaCuarentena;
	protected FabricaPremio fabricaPocion;
	protected FabricaPremio fabricaPrecioso;
	protected FabricaPremio fabricaTemporal;
	
	protected LinkedList<Entidad> navesEnemigas;
	protected LinkedList<Entidad> premios;
	
	protected int cantidadTandas;
	
	public Nivel(int enemigos, int cantTandas) {
		this.enemigos = enemigos;
		this.fabricaNaveAlpha = new FabricaAlpha();
		this.fabricaNaveBeta = new FabricaBeta();
		this.fabricaCuarentena = new FabricaCuarentena();
		this.fabricaPocion = new FabricaPocion();
		this.fabricaPrecioso = new FabricaPrecioso();
		this.fabricaSuperArma = new FabricaSuperArma();
		this.fabricaTemporal = new FabricaTemporal();
		
		this.navesEnemigas = new LinkedList<Entidad>();
		this.premios = new LinkedList<Entidad>();
		
		this.cantidadTandas = cantTandas;
	}
	
	public FabricaNaveEnemiga getFabricaNaveAlpha() {
		return this.fabricaNaveAlpha;
	}
	
	public FabricaNaveEnemiga getFabricaNaveBeta() {
		return this.fabricaNaveBeta;
	}
	
	public FabricaPremio getFabricaCuarentena() {
		return this.fabricaCuarentena;
	}
	
	public FabricaPremio getFabricaPocion() {
		return this.fabricaPocion;
	}
	
	public FabricaPremio getFabricaPrecioso() {
		return this.fabricaPrecioso;
	}
	
	public FabricaPremio getFabricaSuperArma() {
		return this.fabricaSuperArma;
	}
	
	public FabricaPremio getFabricaTemporal() {
		return this.fabricaTemporal;
	}
	
	abstract public Nivel nextLevel();
	
	abstract public int getCantidadEnemigos();

	abstract public LinkedList<Entidad> getNavesEnemigas();

	public abstract LinkedList<Entidad> getTanda();
}
