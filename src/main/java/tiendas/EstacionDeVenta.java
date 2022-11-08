package tiendas;

import java.util.Scanner;
import jugador.Jugador;
import jugador.Posicion;
import terreno.Entidad;
import terreno.TipoEntidad;

public class EstacionDeVenta implements Entidad {
	public Posicion posicion;
	private static final char RESPUESTA_AFIRMATIVA = 'S';
	private static final char LETRA = '/';
	private Scanner sc;
	
	public EstacionDeVenta(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.4), 0);
		this.sc = null;
	}
	
	public void prompt_mensaje_venta() {
		System.out.println("-----------------------------------");
		System.out.println("Desea vender?");
	}
	
	public void interactuar(Jugador jugador) {
		prompt_mensaje_venta();
		this.sc = new Scanner(System.in);
		char respuesta = sc.next().charAt(0);
		if(respuesta == RESPUESTA_AFIRMATIVA) {
			vender(jugador);
		}
	}
	
	public char getLetra() {
		return EstacionDeVenta.LETRA;
	}
		
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public TipoEntidad getTipoEntidad() {
		return TipoEntidad.TIENDA;
	}

	public void vender(Jugador jugador) {
		jugador.venderMinerales();
	}
	
}
