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

	//Esto medio que tiene dependencias implícitas pero no sé cómo se solucionaría
	//Lo que ganamos es que podemos crear distintas configuraciones y pasárselas a PisoSuperior y que las use
	//Entonces podemos ir cambiando el PisoSuperior a nuestro antojo sin tocar PisoSuperior
	//Sería Strategy, en el fondo, pero lo hice sin darme cuenta de eso :P
	public ConfigPisoSuperior(){
		this.crearConfiguracion();
	}

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
	
	public List<Entidad> getTiendas(){
		return this.tiendas;
	}
}