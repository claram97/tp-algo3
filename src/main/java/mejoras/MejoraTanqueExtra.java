package mejoras;

import jugador.Jugador;

public class MejoraTanqueExtra implements Usable {
	private static final char LETRA = 'F';
	public static final int VALOR = 2000;
	private int cantidadCombustible;
	
	public MejoraTanqueExtra() {
		this.cantidadCombustible = 25;
	}

	//Hay que ver qué hacemos si no se gasta todo :P
	public void utilizar(Jugador jugador) {
		jugador.cargarCombustible(cantidadCombustible,0);
	}

	@Override
	public char getLetra() {
		return LETRA;
	}

	@Override
	public TipoUsable getTipo() {
		return TipoUsable.TANQUE_EXTRA;
	}

	@Override
	public int getCosto() {
		return VALOR;
	}

}
