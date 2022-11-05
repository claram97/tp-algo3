package tp;

import java.util.Scanner;

public class EstacionDeReparacion implements EstacionDeMantenimiento, Entidad {
	public Posicion posicion;
	private static final int PRECIO_REPARACION = 15;
	private static final char LETRA = '!';
	
	public EstacionDeReparacion(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.6), 0);
	}
		
	public void reparar(Jugador jugador, int gasto) {
		int hpPedidos = gasto/PRECIO_REPARACION;
		int hpFaltante = jugador.getMaxHP() - jugador.getHp();
		int hpReparados = hpPedidos < hpFaltante ? hpPedidos : hpFaltante;
		int gastoEfectivo = (hpReparados * PRECIO_REPARACION) < gasto ? (hpReparados * PRECIO_REPARACION) : gasto;
		
		if(jugador.hacerCompra(gastoEfectivo)) {
			jugador.repararDmg(hpReparados);
		}
	}
	
	public void prompt_reparacion(int vidaActual) {
		System.out.println("-----------------------------------");
		System.out.println("Su vida actual es " + vidaActual);
		System.out.println("Valor de la reparacion: ");
		System.out.println("50, 100, 200, 500 o 1000(Reparacion completa)");
		System.out.print("Opcion: ");
	}
	
	public void vender(Jugador jugador, int cantidad) {
		reparar(jugador, cantidad);
	}

	@Override
	public void interactuar(Jugador jugador) {
		prompt_reparacion(jugador.getHp());
		Scanner sc = new Scanner(System.in);
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
