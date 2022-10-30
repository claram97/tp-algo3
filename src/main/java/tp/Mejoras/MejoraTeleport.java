package tp.Mejoras;

import java.util.Random;

import tp.Jugador;

public class MejoraTeleport {
	public static int VALOR = 2000;
	public static char LETRA = 'Q';
	
	public void utilizar(Jugador jugador,int maxTerreno) {
		jugador.setX(new Random().nextInt(maxTerreno));
		jugador.setY(0); //0 o donde sea que sea la superficie :P
	}
}

//No sigue ninguna interfaz :(
