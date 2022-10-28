package tp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EstacionDeServicio implements EstacionDeMantenimiento, Entidad {
	public Posicion posicion;
	private static final List<Integer> litrosDisponibles = Arrays.asList(5, 10, 25, 50, 100);
	private static final int PRECIO_COMBUSTIBLE = 1;
	
	public EstacionDeServicio(int tamanioTerreno) {
		this.posicion = new Posicion((int)(tamanioTerreno * 0.3), 0);
	}
	
	//No sé si está bien esto así xd hay que re-factorizarlo seguro seguro
	public int cantidadDeDinero(int cantidadCombustible, int capacidadTanque, int cantidadActual) {
		if(!litrosDisponibles.contains(cantidadCombustible)) return -1; //Excepciones je!

		int i = litrosDisponibles.indexOf(cantidadCombustible);
		if(litrosDisponibles.get(i) == 100) {
			return (capacidadTanque - cantidadActual) * PRECIO_COMBUSTIBLE;
		}
		
		if(litrosDisponibles.get(i) > capacidadTanque - cantidadActual) {
			return (capacidadTanque - cantidadActual) * PRECIO_COMBUSTIBLE;
		}
		
		return litrosDisponibles.get(i) * PRECIO_COMBUSTIBLE;
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
	
	//esto está todo muy mal armado xdddd muy mal la lógica y encima no chequeo que si es 0 no tiene que cargar 0 tiene que cargar full AAAAA
	public void vender(Jugador jugador) {
		prompt_nafta();
		Scanner sc = new Scanner(System.in);
		int cantidad = sc.nextInt(); //Falta chequeo.
		int precio = cantidadDeDinero(cantidad, jugador.getCapacidadTanque(), jugador.getNivelCombustible());
		if(precio == -1) return;
		
		jugador.cargarCombustible(cantidadDeCombustible(precio), precio);
	}

	@Override
	public void interactuar(Jugador jugador) {
		vender(jugador);
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
