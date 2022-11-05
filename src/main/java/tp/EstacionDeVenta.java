package tp;

import java.util.Scanner;

public class EstacionDeVenta {
	public Posicion posicion;
	private static final String RESPUESTA_AFIRMATIVA = "S";
	private static final char LETRA = '/';
	private Scanner sc;
	String respuesta;
	
	public EstacionDeVenta(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.4), 0);
		this.sc = null;
		this.respuesta = null;
	}
	
	public void prompt_mensaje_venta() {
		System.out.println("-----------------------------------");
		System.out.println("Desea vender?");
	}
	
	public void interactuar(Jugador jugador) {
		prompt_mensaje_venta();
		this.sc = new Scanner(System.in);
		this.respuesta = sc.next();
		if(this.respuesta == EstacionDeVenta.RESPUESTA_AFIRMATIVA) {
			comprar(jugador);
		}
	}
	
	
	public void comprar(Jugador jugador) {
		jugador.venderMinerales();
	}
	
	public char getLetra() {
		return EstacionDeVenta.LETRA;
	}
}
