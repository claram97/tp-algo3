package tp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EstacionDeServicio implements EstacionDeMantenimiento, Entidad {
	public Posicion posicion;
	private static final List<Integer> litrosDisponibles = Arrays.asList(5, 10, 25, 50, 100);
	private static final int PRECIO_COMBUSTIBLE = 1;
	private int cantidad;
	private Scanner sc;
	
	public EstacionDeServicio(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.3), 0);
		this.cantidad = 0;
		this.sc = null;
	}
	
	//No sé si está bien esto así xd hay que re-factorizarlo seguro seguro
	public int cantidadDeDinero(int cantidadCombustible, int capacidadTanque, int cantidadActual) {
		if(!litrosDisponibles.contains(cantidadCombustible)) return -1; //Excepciones je!

		int i = litrosDisponibles.indexOf(cantidadCombustible);
		if(litrosDisponibles.get(i) == 100) {
			return (capacidadTanque - cantidadActual) * PRECIO_COMBUSTIBLE;
		}
		
		return cantidadCombustible * PRECIO_COMBUSTIBLE;
	}
	
	public int cantidadDeCombustible(int cantidadDinero) {
		return cantidadDinero/PRECIO_COMBUSTIBLE;
	}
	
	private void prompt_nafta() {
		System.out.println("---------------------------");
		System.out.println("Indique cuanto quiere cargar: 5, 10, 25, 50 (Litros)");
		System.out.println("o indique 100 para llenar el tanque.");
		System.out.println("Cantidad: ");
	}
	
	public void vender(Jugador jugador, int cantidad) {
		int precio = cantidadDeDinero(cantidad, jugador.getCapacidadTanque(), jugador.getNivelCombustible());
		if(precio == -1) return;
		jugador.cargarCombustible(cantidadDeCombustible(precio), precio);
	}

	@Override
	public void interactuar(Jugador jugador) {
		prompt_nafta();
		this.sc = new Scanner(System.in);
		this.cantidad = sc.nextInt();
		if(this.litrosDisponibles.contains(this.cantidad)){
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
