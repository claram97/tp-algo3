package tp;

public class Aire implements Bloque{

	public tipoDeBloque getTipo() {
		return tipoDeBloque.AIRE;
	}

	public int getPrecio() {
		return 0;
	}

	public char getLetra() {
		return ' ';
	}

}
