package tp;

import java.util.ArrayList;

public class PisoSuperior {
	ArrayList<Entidad> tiendas;
	private int ancho;
	
	public PisoSuperior(int ancho, EstacionDeServicio ypf, EstacionDeReparacion mecanico, TiendaDeMejoras mejoras) {
		var tiendas = new ArrayList<Entidad>();
		
		for(int i = 0; i < ancho; i++) {
			tiendas.add(new Aire());
		}
		
		if(ypf != null) {
			tiendas.add(ypf.getPosicion().getPosicionX(), ypf);
		}
		if(mecanico != null) {
			tiendas.add(mecanico.getPosicion().getPosicionX(), mecanico);
		}
		if(mejoras != null) {
			tiendas.add(mejoras.getPosicion().getPosicionX(), mejoras);
		}
		this.tiendas = tiendas;
		this.ancho = ancho;
	}
	
	public Entidad colisionEntidad(Posicion pos) {
		if(this.tiendas != null) {
			return tiendas.get(pos.getPosicionX());
		}
		return null;
	}
	
	public ArrayList<Entidad> devolverTiendas(){
		return this.tiendas;
	}
	
}
