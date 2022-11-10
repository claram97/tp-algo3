package terreno;

import java.util.Map;
import tiendas.EstacionDeReparacion;
import tiendas.EstacionDeServicio;
import tiendas.EstacionDeVenta;
import tiendas.TiendaDeConsumibles;
import tiendas.TiendaDeMejoras;
import tp.Main;
import java.util.HashMap;

public class ConfigPisoSuperior implements ConfigPiso {
	Map<Integer, Entidad> tiendas;

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

		this.tiendas = new HashMap<Integer, Entidad>();
	
		tiendas.put(ypf.getPosicion().getX(), ypf);
		tiendas.put(mecanico.getPosicion().getX(), mecanico);
		tiendas.put(mejoras.getPosicion().getX(), mejoras);
		tiendas.put(consumibles.getPosicion().getX(), consumibles);
		tiendas.put(estacionDeVentas.getPosicion().getX(),estacionDeVentas);
	}
	
	//Devuelve el diccionario de las tiendas
	public Map<Integer, Entidad> getTiendas(){
		return this.tiendas;
	}
	
	@Override
	public Entidad getTiendaPos(int posX) {
		return tiendas.get(posX);
	}
}
