package terreno;

import java.util.List;

import tiendas.EstacionDeReparacion;
import tiendas.EstacionDeServicio;
import tiendas.EstacionDeVenta;
import tiendas.TiendaDeConsumibles;
import tiendas.TiendaDeMejoras;
import tp.Main;

import java.util.ArrayList;

public class ConfigPisoSuperior implements ConfigPiso {
	List<Entidad> tiendas;

	public ConfigPisoSuperior(){
		this.crearConfiguracion();
	}

	//Crear una configuracion especificada.
	public void crearConfiguracion() {
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
	
	//Devuelve la lista de Tiendas.
	public List<Entidad> getTiendas(){
		return this.tiendas;
	}
}
