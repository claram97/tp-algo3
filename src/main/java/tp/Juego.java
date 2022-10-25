package tp;

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
	
	private void interaccionBloques() {
		this.terreno.romperBloque(jugador.getY(), jugador.getX());
	}

	private boolean jugadorDebeCaer(){
		jugador.setY(jugador.getY()+1);
		boolean cae = false;
		if(terreno.casilleroVacio(jugador.getPosicion())){
			cae = true;
		}
		jugador.setY(jugador.getY()-1);
		return cae;
	}
	
	private estadoDelJuego estadoJuego(){
		if(jugador.seEstrello() || jugador.seQuedoSinCombustible()){
			return estadoDelJuego.PERDIDO;
		}
		//Falta un if para si ganó :P
		return estadoDelJuego.JUGANDO;
	}
	
	
	public void gameLoop() {
		terreno.imprimirTerreno(this.jugador);
		Scanner input = new Scanner(System.in);
		
		while(estadoJuego == estadoDelJuego.JUGANDO) {
			char movimiento = input.next().charAt(0);
			jugador.mover(movimiento);
			//Acá habría que ver cómo armar un contador que cuente la altura de la que cae e implementar la función que calcula el daño según la altura :P
			while(jugadorDebeCaer()){
				jugador.caer();
			}
			interaccionBloques();
			terreno.imprimirTerreno(jugador);
		}
	}
	
	
	
}
