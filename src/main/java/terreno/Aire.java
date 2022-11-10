package terreno;

import jugador.Jugador;
import jugador.Posicion;

public class Aire implements Bloque, Entidad{
	public static final char LETRA = ' ';
	
	//Devuelve la letra que representa a la clase
	public char getLetra() {
		return Aire.LETRA;
	}

	//Esto es cualquier cosa. Estamos haciendo algo mal porque no puede ser que interactuar no haga nada y que la posicion te devuelva null cuando se supone que tenga una posicion
	
	@Override
	//Permite la interacción con el Jugador dado.
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
