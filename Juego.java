package tp;

import java.util.Scanner;

public class Juego {
	Terreno terreno;
	Jugador jugador;
	boolean jugando;
	
	public Juego(Terreno terreno, Jugador jugador) {
		this.terreno = terreno;
		this.jugador = jugador;
		this.jugando = true;
	}
	
	private void interaccionBloques() {
		this.terreno.romperBloque(jugador.getY(), jugador.getX());
	}
	
	public void gameLoop() {
		terreno.imprimirTerreno(this.jugador);
		Scanner sc = new Scanner(System.in);
		
		while(jugando) {
			char mov = sc.next().charAt(0);
			jugador.mover(mov);
			interaccionBloques();
			terreno.imprimirTerreno(jugador);
		}
	}
	
	
	
}
