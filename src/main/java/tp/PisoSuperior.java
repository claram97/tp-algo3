package tp;

import java.util.List;

public class PisoSuperior {
	ConfigPiso config;
	
	//I did my best para separar la inicialización del piso superior del piso superior en sí :P
	//Ahora el piso no se crea siempre igual, sino que le pasas una configuración y te crea el Piso Superior jeje
	public PisoSuperior(ConfigPiso config) {
		if(config == null) {
			//throw an exception
		}
		this.config = config;
	}
	
	public Entidad colisionEntidad(Posicion pos) {
		if(this.config.getTiendas() != null) {
			return this.config.getTiendas().get(pos.getX());
		}
		return null;
	}
	
	public List<Entidad> devolverTiendas(){
		return this.config.getTiendas();
	}
	
}
