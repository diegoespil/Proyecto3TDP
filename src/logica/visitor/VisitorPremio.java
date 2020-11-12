package logica.visitor;

import logica.entidad.Entidad;
import logica.naves.NaveInfectada;
import logica.naves.NaveJugador;
import logica.premios.Premio;
import logica.proyectil.Proyectil;

public class VisitorPremio extends Visitor {

	public VisitorPremio(Entidad e) {
		super(e);
	}
	
	public void visit(NaveInfectada nave) {
		
	};
	
	public void visit(NaveJugador nave) {
		
	};
	
	public void visit(Proyectil proyectil) {
		
	};

	public void visit(Premio premio) {
		
	};
}
