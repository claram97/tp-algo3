package tp.Mejoras;

import tp.Jugador;

public class MejoraTanqueExtra implements Usable {
	private static char LETRA = 'F';
	public static int VALOR = 2000;
	private int cantidadCombustible;
	
	public MejoraTanqueExtra() {
		this.cantidadCombustible = 25;
	}

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
