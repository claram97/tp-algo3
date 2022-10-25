package tp;

public class Mineral implements Bloque {
	//Diamante debería ser inusual :P
	private tipoDeBloque tipoMineral;
	private int precio;
	private Posicion posicion;
	private char letra;
	
	public Mineral(tipoDeBloque tipoMineral,int precio,char letra) {
		this.precio = precio;
		this.tipoMineral = tipoMineral;
		this.letra = letra;
		this.posicion = null; //Esto se debería setear después si es que es necesario tener la posición :P
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public tipoDeBloque getTipo() {
		return this.tipoMineral;
	}
	
	public char getLetra() {
		return this.letra;
	}
}
