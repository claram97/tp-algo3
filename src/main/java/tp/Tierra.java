package tp;

public class Tierra implements Bloque{
	char letra;
	private Posicion posicion;
	

	public Tierra() {
		this.letra = 'T';
		this.posicion = null;
	}

	public int getPrecio() {
		return -1;
	}

	public TipoDeBloque getTipo() {
		return TipoDeBloque.TIERRA;
	}

	public char getLetra() {
		return 'T';
	}

}
