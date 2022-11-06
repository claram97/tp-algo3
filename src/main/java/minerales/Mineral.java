package minerales;

import jugador.Posicion;
import terreno.Bloque;

public abstract class Mineral implements Bloque {
	private int precio;
	private Posicion posicion;
	private char letra;
	
	public Mineral(int precio,char letra) {
		this.precio = precio;
		this.letra = letra;
		this.posicion = null;
	}
	
	public void setPosicion(Posicion posicion) {
		if(posicion == null) {
			//throw exception
		}
		if(posicion.getX() < 0 || posicion.getY() < 0) {
			//throw exception
		}
		this.posicion = posicion;
		
	}
	public int getPrecio() {
		return this.precio;
	}
	
	public char getLetra() {
		return this.letra;
	}
}
