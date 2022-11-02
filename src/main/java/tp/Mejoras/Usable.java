package tp.Mejoras;

import tp.Jugador;

public interface Usable {
	
	public void utilizar(Jugador jugador);
	
	public char getLetra();
	
	public TipoUsable getTipo();
	
}
