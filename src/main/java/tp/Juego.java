package tp;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	Terreno terreno;
	Jugador jugador;
	enum estadoDelJuego{JUGANDO,PERDIDO,GANADO};
	estadoDelJuego estadoJuego;
	
	public Juego(Terreno terreno, Jugador jugador) {
		this.terreno = terreno;
		this.jugador = jugador;
		this.estadoJuego = estadoDelJuego.JUGANDO;
	}
	

	private estadoDelJuego estadoJuego(){
		if(jugador.seEstrello() || jugador.seQuedoSinCombustible()){
			return estadoDelJuego.PERDIDO;
		}
		//Falta un if para si ganó :P
		return estadoDelJuego.JUGANDO;
	}
	
	//Esto probablemente se pueda poner mas bonito, Diego uso un diccionario por ej.
	private int difX(char mov) {
		if(mov == 'A') {
			return -1;
		} else if(mov == 'D') {
			return 1;
		} else {
			return 0;
		}
	}

	private int difY(char mov) {
		if(mov == 'W') {
			return -1;
		} else if(mov == 'S') {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	public void gameLoop() {
		terreno.imprimirTerreno(this.jugador);
		Scanner input = new Scanner(System.in);
		ArrayList<AccionJugador> acciones;
		
		while(estadoJuego == estadoDelJuego.JUGANDO) {
			char movimiento = input.next().charAt(0);
			int dx = difX(movimiento);
			int dy = difY(movimiento);
			var accion = new AccionJugador(jugador, terreno, dx, dy);
			accion.aplicar();
			terreno.romperBloque(jugador.getPosicion());
			//Acá habría que ver cómo armar un contador que cuente la altura de la que cae e implementar la función que calcula el daño según la altura :P
//			No funciona bien
//			while(jugadorDebeCaer()){
//				jugador.caer();
//			}
			terreno.imprimirTerreno(jugador);
			jugador.mostrarInventario();
		}
	}
	
	
	
}
