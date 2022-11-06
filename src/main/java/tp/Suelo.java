package tp;

public class Suelo {
	ConfigSuelo config;
	
	public Suelo(ConfigSuelo config) {
		if(config == null) {
			//throw an exception
		}
		
		this.config = config;
		
	}
	
	public Bloque getBloque(Posicion pos) {
		return config.getBloque(pos);
	}
	
	public void destruirBloque(Posicion pos) {
		config.destruirBloque(pos);
	}
	
	public boolean casilleroVacio(Posicion posicion) {
		return config.casilleroVacio(posicion);
	}
	
	
}
