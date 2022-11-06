package tp.Mejoras;

import java.util.Random;

import tp.Jugador;
import tp.Main;

public class MejoraTeleport implements Usable {
	public static int VALOR = 2000;
	public static char LETRA = 'Q';

	public void utilizar(Jugador jugador) {
		jugador.setX(new Random().nextInt(Main.ANCHO));
		jugador.setY(0); //0 o donde sea que sea la superficie :P
	}

	@Override
	public char getLetra() {
		return LETRA;
	}

	@Override
	public TipoUsable getTipo() {
		return TipoUsable.TELEPORT;
	}

	@Override
	public int getCosto() {
		return VALOR;
	}
}

//No sigue ninguna interfaz :(
