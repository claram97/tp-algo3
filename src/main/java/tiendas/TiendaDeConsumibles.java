package tiendas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jugador.Jugador;
import jugador.Posicion;
import mejoras.MejoraDinamita;
import mejoras.MejoraHullRepairNanobots;
import mejoras.MejoraTanqueExtra;
import mejoras.MejoraTeleport;
import mejoras.Usable;
import terreno.Entidad;
import terreno.TipoEntidad;

public class TiendaDeConsumibles implements Entidad {
	Posicion posicion;
	Map<Character, Usable> usables;
	
	public void inicializarConsumibles() {
		this.usables.put('R', new MejoraHullRepairNanobots());
		this.usables.put('X', new MejoraTanqueExtra());
		this.usables.put('T', new MejoraTeleport());
		this.usables.put('D', new MejoraDinamita(null));
	}
	
	public TiendaDeConsumibles(int ancho) {
		super();
		this.posicion = new Posicion((int)(ancho * 0.7), 0);
		this.usables = new HashMap<>();
		inicializarConsumibles();
	}
	
	public void prompt_consumibles() {
		System.out.println("---------------------------------------");
		System.out.println("Consumible a comprar: ");
		System.out.println("D para dinamita, E para explosivos, R para HullRepair, X para tanque extra, T para tp");
		System.out.print("Opcion: ");
	}
	
	public void vender(Jugador jugador, char opcion) {
		Usable objeto = usables.get(opcion);
		
		if(objeto == null) {
			System.out.println("No tenemos ese item");
			return;
		}
		
		if(jugador.hacerCompra(objeto.getCosto())) {
			jugador.agregarUsable(objeto);
		}
	}
	

	@Override
	public void interactuar(Jugador jugador) {
		Scanner scanner = new Scanner(System.in);
		prompt_consumibles();
		char opcion = scanner.next().charAt(0);
		//str es un manejo choto pero no puedo buscar que es mejor.
		vender(jugador, opcion);
	}

	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public TipoEntidad getTipoEntidad() {
		return TipoEntidad.TIENDA;
	}

	@Override
	public char getLetra() {
		return '*';
	}
	
	
	
}
