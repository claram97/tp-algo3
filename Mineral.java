package tp;


public class Mineral implements Bloque {
	//Diamante debería ser inusual :P
	private tipoDeMineral tipoMineral;
	private int precio;
	private Posicion posicion;
	private char letra;
	
	
	private void setLetra(tipoDeMineral tipoMineral) {
		if(tipoMineral == tipoDeMineral.COBRE) {
			this.letra = 'C';
		}
		else if(tipoMineral == tipoDeMineral.BRONCE) {
			this.letra = 'B';
		}
		else if(tipoMineral == tipoDeMineral.HIERRO) {
			this.letra = 'H';
		}
		else if(tipoMineral == tipoDeMineral.PLATA) {
			this.letra = 'P';
		}
		else if(tipoMineral == tipoDeMineral.ORO) {
			this.letra = 'O';
		}
		else {
			//throw exception
		}
	}
	
	
//Acá hay muchos if, hay que aplicar algún patrón quizás :P
	private int setPrecio(tipoDeMineral tipoMineral) {
		if(tipoMineral == tipoDeMineral.COBRE) {
			return 50;
		}
		else if(tipoMineral == tipoDeMineral.BRONCE) {
			return 60;
		}
		else if(tipoMineral == tipoDeMineral.HIERRO) {
			return 30;
		}
		else if(tipoMineral == tipoDeMineral.PLATA) {
			return 50;
		}
		else if(tipoMineral == tipoDeMineral.ORO) {
			return 50;
		}
		else {
			return -1;
		}
	}
	
//ta raro perdón
	private boolean esTipoValido(tipoDeMineral mineral) {
		return (mineral == tipoDeMineral.COBRE || mineral == tipoDeMineral.BRONCE || mineral == tipoDeMineral.HIERRO || mineral == tipoDeMineral.PLATA || mineral == tipoDeMineral.ORO);
	}
	
	
	public Mineral(tipoDeMineral tipoMineral) {
		if(!esTipoValido(tipoMineral)) {
			//throw an exception for invalid type
		}
		this.precio = setPrecio(tipoMineral);
		this.tipoMineral = tipoMineral;
		setLetra(tipoMineral);		
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
