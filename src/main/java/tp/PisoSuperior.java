package tp;

import java.util.ArrayList;

public class PisoSuperior {
	ArrayList<Entidad> tiendas;
	private int ancho;
	
	public PisoSuperior(int ancho, EstacionDeServicio ypf, EstacionDeReparacion mecanico, TiendaDeMejoras mejoras, TiendaDeConsumibles consumibles) {
		var tiendas = new ArrayList<Entidad>();
		
		for(int i = 0; i < ancho; i++) {
			tiendas.add(new Aire());
		}
		
		if(ypf != null) {
			tiendas.add(ypf.getPosicion().getX(), ypf);
		}
		if(mecanico != null) {
			tiendas.add(mecanico.getPosicion().getX(), mecanico);
		}
		if(mejoras != null) {
			tiendas.add(mejoras.getPosicion().getX(), mejoras);
		}
		if(consumibles != null) {
			tiendas.add(consumibles.getPosicion().getX(), consumibles);
		}
		
		this.tiendas = tiendas;
		this.ancho = ancho;
	}
	
	public Entidad colisionEntidad(Posicion pos) {
		if(this.tiendas != null) {
			return tiendas.get(pos.getX());
		}
		return null;
	}
	
	public ArrayList<Entidad> devolverTiendas(){
		return this.tiendas;
	}
	
}
