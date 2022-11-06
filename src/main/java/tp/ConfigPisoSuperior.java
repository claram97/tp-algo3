package tp;

import java.util.List;
import java.util.ArrayList;

public class ConfigPisoSuperior{

	List<Entidad> tiendas;

	public ConfigPisoSuperior(){
		var ypf = new EstacionDeServicio(Main.ANCHO);
		var mecanico = new EstacionDeReparacion(Main.ANCHO);
		var mejoras = new TiendaDeMejoras(Main.ANCHO);
		var consumibles = new TiendaDeConsumibles(Main.ANCHO);
		var estacionDeVentas = new EstacionDeVenta(Main.ANCHO);

		this.tiendas = new ArrayList<>();
	
		for(int i = 0; i < Main.ANCHO; i++) {
			tiendas.add(new Aire());
		}
		
		tiendas.add(ypf.getPosicion().getX(), ypf);
		tiendas.add(mecanico.getPosicion().getX(), mecanico);
		tiendas.add(mejoras.getPosicion().getX(), mejoras);
		tiendas.add(consumibles.getPosicion().getX(), consumibles);
		tiendas.add(estacionDeVentas.getPosicion().getX(),estacionDeVentas);
	}

	public List<Entidad> getTiendas(){
		return this.tiendas;
	}
}