package terreno;

import java.util.List;

import jugador.Posicion;

public class PisoSuperior {
	ConfigPiso config;

	public PisoSuperior(ConfigPiso config) {
		if(config == null) {
			//throw an exception
		}
		this.config = config;
	}
	
	//Verifica si hay colision con una entidad.
	public Entidad colisionEntidad(Posicion pos) {
		if(this.config.getTiendas() != null) {
			return this.config.getTiendas().get(pos.getX());
		}
		return null;
	}
	
	//Devuelve las tiendas.
	public List<Entidad> devolverTiendas(){
		return this.config.getTiendas();
	}
	
}
