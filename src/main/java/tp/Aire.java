package tp;

public class Aire implements Bloque, Entidad{

	public TipoDeBloque getTipo() {
		return TipoDeBloque.AIRE;
	}

	public int getPrecio() {
		return 0;
	}

	public char getLetra() {
		return ' ';
	}

	@Override
	public void interactuar(Jugador jugador) {
	}

	@Override
	public Posicion getPosicion() {
		return null;
	}

	@Override
	public TipoEntidad getTipoEntidad() {
		return TipoEntidad.AIRE;
	}

}
