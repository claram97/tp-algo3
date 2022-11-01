package tp.Mejoras;

import tp.Jugador;

public class MejoraTanqueExtra extends MejoraDeJugador {
	private static char LETRA = 'F';
	public static int VALOR = 2000;
	private int cantidadCombustible;
	
	public MejoraTanqueExtra() {
		this.cantidadCombustible = 25;
		super.letra = MejoraTanqueExtra.LETRA;
	}

	public void utilizar(Jugador jugador) {
		jugador.cargarCombustible(cantidadCombustible,0);
	}

}
