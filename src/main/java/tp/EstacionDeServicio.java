package tp

import java.util.Scanner;

public class EstacionDeServicio implements EstacionDeMantenimiento {
	public Posicion posicion;
	private static final int PRECIO_COMBUSTIBLE = 1;
	
	public EstacionDeServicio(int tamanioTerreno) {
		this.posicion.set((int)(tamanioTerreno * 0.3),0);
	}
	
	//No sé si está bien esto así xd hay que re-factorizarlo seguro seguro
	public int cantidadDeDinero(CantidadDeCarga cantidad) {
		if(cantidad == CantidadDeCarga.SUPERMIN) {
			return 5 * PRECIO_COMBUSTIBLE;
		}
		else if(cantidad == CantidadDeCarga.MIN) {
			return 10 * PRECIO_COMBUSTIBLE;
		}
		else if(cantidad == CantidadDeCarga.MEDIO) {
			return 25 * PRECIO_COMBUSTIBLE;
		}
		else if(cantidad == CantidadDeCarga.MAX) {
			return 50 * PRECIO_COMBUSTIBLE;
		}
		else if(cantidad == CantidadDeCarga.FULL) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public int cantidadDeCombustible(CantidadDeCarga cantidad) {
		if(cantidad == CantidadDeCarga.SUPERMIN) {
			return 5;
		}
		else if(cantidad == CantidadDeCarga.MIN) {
			return 10;
		}
		else if(cantidad == CantidadDeCarga.MEDIO) {
			return 25;
		}
		else if(cantidad == CantidadDeCarga.MAX) {
			return 50;
		}
		else if(cantidad == CantidadDeCarga.FULL) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	//esto está todo muy mal armado xdddd muy mal la lógica y encima no chequeo que si es 0 no tiene que cargar 0 tiene que cargar full AAAAA
	public void vender(Jugador jugador) {
		//Por ahora lo podríamos hacer por pantalla no sé por ahora yo lo calculé con un enum (?)
		if(this.cantidadDeDinero(jugador.cargarCombustible()) != -1) {
			jugador.cargarCombustible(this.cantidadDeCombustible(jugador.cargarCombustible()),this.cantidadDeDinero(jugador.cargarCombustible()));
		}
		else {
			//throw exception
		}
	}
	
}
