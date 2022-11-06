package terreno;

import jugador.Posicion;

public class Tierra implements Bloque{
	private static final char LETRA = 'T';
	private Posicion posicion;
	

	public Tierra() {
		this.posicion = null;
	}
	
	public void setPosicion(Posicion pos) {
		if(pos == null) {
			//throw an exception
		}
		this.posicion = pos;
	}

	public char getLetra() {
		return Tierra.LETRA;
	}

}
