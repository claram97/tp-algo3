package tp;

import java.util.ArrayList;
import java.util.Scanner;

import tp.Mejoras.*;


public class Juego {
	Suelo suelo;
	PisoSuperior tiendas;
	Jugador jugador;
	Terreno terreno;
	Scanner input;
	
	public Juego(Suelo suelo, PisoSuperior tiendas, Jugador jugador) {
		if(suelo == null || tiendas == null || jugador == null) {
			//throw an exception
		}
		this.suelo = suelo;
		this.jugador = jugador;
		this.tiendas = tiendas;
		this.input = null;
		this.terreno = new Terreno(tiendas, suelo, jugador, Main.ANCHO, Main.ALTURA);
	}
	

	private EstadoDelJuego estadoJuego(){
		if(jugador.seEstrello() || jugador.seQuedoSinCombustible()){
			return EstadoDelJuego.PERDIDO;
		}
		if(jugador.getX() == this.terreno.getAlto()) {
			return EstadoDelJuego.GANADO;
		}
		return EstadoDelJuego.JUGANDO;
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
	
	public void convertirInput(char movimiento, ArrayList<Accion> acciones) {
		//Ahora lee caracteres y quizas quedo medio croto, pero esto se puede trasladar facil a un Map o algo.
		if(movimiento == 'W' || movimiento == 'S' || movimiento == 'A' || movimiento == 'D') {
			int dx = difX(movimiento);
			int dy = difY(movimiento);
			var accion = new AccionMovimiento(jugador, suelo, tiendas, dx, dy);
			acciones.add(accion);
		} else if(movimiento == 'F' || movimiento == 'Q' || movimiento == 'R') {
			acciones.add(mejoraJugador(movimiento));
		} else if(movimiento == 'X') {
			AccionItemTerreno accion = new AccionItemTerreno(jugador, new MejoraDinamita(suelo));
			acciones.add(accion);
		}
	}
	
	//Para poder realizar pruebas.
	public void realizarAccion(ArrayList<Accion> acciones) {
		//Una especie de "cola de acciones". Creo que se puede trasladar a una version mas dinamica con fps y actualizacion y eso :D.
		if(acciones.size() > 0) {
			if(acciones.get(0) != null) {
				acciones.get(0).aplicar();
			}
			acciones.remove(0);
		}
	}
	
	
	
	public void gameLoop() {
		this.input = new Scanner(System.in);
		var acciones = new ArrayList<Accion>();
		terreno.imprimirTerreno(jugador);
		while(this.estadoJuego() == EstadoDelJuego.JUGANDO) {
			char movimiento = input.next().charAt(0);
			convertirInput(movimiento, acciones);
			realizarAccion(acciones);
			terreno.imprimirTerreno(jugador);
			jugador.mostrarInventario();
		}
	}
		
}
