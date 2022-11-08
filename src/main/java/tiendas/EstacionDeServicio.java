package tiendas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import jugador.Jugador;
import jugador.Posicion;
import terreno.Entidad;
import terreno.TipoEntidad;

public class EstacionDeServicio implements EstacionDeMantenimiento, Entidad {
	public Posicion posicion;
	private static final List<Integer> LITROS_DISPONIBLES = Arrays.asList(5, 10, 25, 50, 100);
	private static final int PRECIO_COMBUSTIBLE = 1;
	private int cantidad;
	private Scanner sc;
	
	public EstacionDeServicio(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.3), 0);
		this.cantidad = 0;
		this.sc = null;
	}
	
	public double cantidadDeDinero(double cantidadCombustible, double capacidadTanque, double cantidadActual) {
		if(!LITROS_DISPONIBLES.contains((int)cantidadCombustible)) {
			return -1;
			//throw exception
		}
		int i = LITROS_DISPONIBLES.indexOf((int)cantidadCombustible);
		if(LITROS_DISPONIBLES.get(i) == 100) {
			return (capacidadTanque - cantidadActual) * EstacionDeServicio.PRECIO_COMBUSTIBLE;
		}
		
		return cantidadCombustible * EstacionDeServicio.PRECIO_COMBUSTIBLE;
	}
	
	public double cantidadDeCombustible(double cantidadDinero) {
		return cantidadDinero/EstacionDeServicio.PRECIO_COMBUSTIBLE;
	}
	
	private void prompt_nafta() {
		System.out.println("---------------------------");
		System.out.println("Indique cuanto quiere cargar: 5, 10, 25, 50 (Litros)");
		System.out.println("o indique 100 para llenar el tanque.");
		System.out.println("Cantidad: ");
	}
	
	public void vender(Jugador jugador, double cantidad) {
		double precio = cantidadDeDinero(cantidad, jugador.getCapacidadTanque(), jugador.nivelDeCombustible());
		if(precio == -1) {
			return;
		}
		jugador.cargarCombustible(cantidadDeCombustible(precio), precio);
	}

	@Override
	public void interactuar(Jugador jugador) {
		prompt_nafta();
		this.sc = new Scanner(System.in);
		this.cantidad = sc.nextInt();
		if(EstacionDeServicio.LITROS_DISPONIBLES.contains(this.cantidad)){
			vender(jugador,this.cantidad);
		}
	}

	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public char getLetra() {
		return '#';
	}

	@Override
	public TipoEntidad getTipoEntidad() {
		return TipoEntidad.TIENDA;
	}
	
}
