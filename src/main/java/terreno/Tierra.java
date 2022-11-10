package terreno;

import jugador.Posicion;

public class Tierra implements Bloque{
	private static final char LETRA = 'T';
	private Posicion posicion;
	
	public Tierra() {
		this.posicion = null;
	}
	
	//Permite setear la posicion.
	public void setPosicion(Posicion pos) {
		if(pos == null) {
			//throw an exception
		}
		if(pos.getX() >= 0 && pos.getY() >= 0){
			this.posicion = pos;
		}
	}

	//Devuelve la letra que representa la clase.
	public char getLetra() {
		return Tierra.LETRA;
	}

}
