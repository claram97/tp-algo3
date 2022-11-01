package tp;

import java.util.ArrayList;

public class PisoSuperior {
	ArrayList<Entidad> tiendas;
	private int ancho;
	
	public PisoSuperior(int ancho, EstacionDeServicio ypf, EstacionDeReparacion mecanico, TiendaDeMejoras mejoras) {
		var tiendas = new ArrayList<Entidad>();
		if(ypf != null) {
			tiendas.add(ypf);
		}
		if(mecanico != null) {
			tiendas.add(mecanico);
		}
		if(mejoras != null) {
			tiendas.add(mejoras);
		}
		this.tiendas = tiendas;
		this.ancho = ancho;
	}
	
	public Entidad colisionEntidad(Posicion pos) {
		if(this.tiendas != null) {
			for(Entidad e: tiendas) {
				if(e.getPosicion().esPosicionIgual(pos)) {
					return e;
				}
			}
		}
		return null;
	}
	
	public ArrayList<Entidad> devolverTiendas(){
		return this.tiendas;
	}
	
}
