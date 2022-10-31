package tp;

import java.util.ArrayList;
import java.util.Scanner;

import tp.Mejoras.*;


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
	
	//Ahora deja utilizar libremente cada mejora. Hay que completar la implementacion de la lista de mejoras en jugador y agregar las restricciones aca.
	private AccionItem mejoraJugador(char tecla) {
		AccionItem accion;
		if(tecla == 'F') {
			accion = new AccionItem(jugador, new MejoraTanqueExtra());
		} else if(tecla == 'Q') {
			accion = new AccionItem(jugador, new MejoraTeleport());
		} else if(tecla == 'R') {
			accion = new AccionItem(jugador, new MejoraHullRepairNanobots());
		} else {
			accion = null;
		}
		return accion;
	}
	
	
	public void gameLoop() {
		terreno.imprimirTerreno(this.jugador);
		Scanner input = new Scanner(System.in);
		var acciones = new ArrayList<Accion>();
		
		while(estadoJuego == estadoDelJuego.JUGANDO) {
			char movimiento = input.next().charAt(0);
			
			//Ahora lee caracteres y quizas quedo medio croto, pero esto se puede trasladar facil a un Map o algo.
			if(movimiento == 'W' || movimiento == 'S' || movimiento == 'A' || movimiento == 'D') {
				int dx = difX(movimiento);
				int dy = difY(movimiento);
				var accion = new AccionMovimiento(jugador, terreno, dx, dy);
				acciones.add(accion);
			} else if(movimiento == 'F' || movimiento == 'Q' || movimiento == 'R') {
				acciones.add(mejoraJugador(movimiento));
			}
			
			//Una especie de "cola de acciones". Creo que se puede trasladar a una version mas dinamica con fps y actualizacion y eso :D.
			if(acciones.size() > 0) {
				if(acciones.get(0) != null) {
					acciones.get(0).aplicar();
				}
				acciones.remove(0);
			}
			
			
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
