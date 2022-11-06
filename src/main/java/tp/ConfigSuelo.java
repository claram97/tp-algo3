package tp;

public interface ConfigSuelo {
	public Bloque getBloque(Posicion pos);
	public void destruirBloque(Posicion pos);
	public boolean casilleroVacio(Posicion posicion);
}
