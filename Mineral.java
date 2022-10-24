package tp;


public class Mineral implements Bloque {
	public enum tipoDeMineral{COBRE,BRONCE,PLATA,ORO,HIERRO,DIAMANTE};
	//Diamante debería ser inusual :P
	private tipoDeMineral tipoMineral;
	private int precio;
	private Posicion posicion;
	private char letra;
	
	public Mineral(tipoDeMineral tipoMineral,int precio,char letra) {
		this.precio = precio;
		this.tipoMineral = tipoMineral;
		this.letra = letra;
		this.posicion = null; //Esto se debería setear después si es que es necesario tener la posición :P
	}
	
	public int getPrecio() {
		return this.precio;
	}
	
	public tipoDeMineral getTipo() {
		return this.tipoMineral;
	}
	
	public char getLetra() {
		return this.letra;
	}
}

