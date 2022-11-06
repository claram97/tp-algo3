package terreno;

import jugador.Jugador;
import jugador.Posicion;

public class Aire implements Bloque, Entidad{
	public static final char LETRA = ' ';
	
	public char getLetra() {
		return Aire.LETRA;
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
