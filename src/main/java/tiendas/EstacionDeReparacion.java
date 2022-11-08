package tiendas;

import java.util.Scanner;

import jugador.Jugador;
import jugador.Posicion;
import terreno.Entidad;
import terreno.TipoEntidad;

public class EstacionDeReparacion implements EstacionDeMantenimiento, Entidad {
	public Posicion posicion;
	private static final int PRECIO_REPARACION = 15;
	private static final char LETRA = '!';
	private Scanner sc;
	
	public EstacionDeReparacion(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.6), 0);
		this.sc = null;
	}
	
	public void prompt_reparacion(int vidaActual) {
		System.out.println("-----------------------------------");
		System.out.println("Su vida actual es " + vidaActual);
		System.out.println("Valor de la reparacion: ");
		System.out.println("50, 100, 200, 500 o 1000(Reparacion completa)");
		System.out.print("Opcion: ");
	}
	
	public void vender(Jugador jugador, double gasto) {
		double hpPedidos = gasto/PRECIO_REPARACION;
		double hpFaltante = jugador.getNave().getMaxHP() - jugador.getNave().getHP();
		double hpReparados = hpPedidos < hpFaltante ? hpPedidos : hpFaltante;
		double gastoEfectivo = (hpReparados * PRECIO_REPARACION) < gasto ? (hpReparados * PRECIO_REPARACION) : gasto;
		
		if(jugador.hacerCompra(gastoEfectivo)) {
			jugador.getNave().repararDmg((int)hpReparados);
		}
	}

	@Override
	public void interactuar(Jugador jugador) {
		prompt_reparacion(jugador.getNave().getHP());
		this.sc = new Scanner(System.in);
		int cantidadPlata = sc.nextInt();
		vender(jugador, cantidadPlata);
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
		return EstacionDeReparacion.LETRA;
	}
}
