package mejoras;

import jugador.Jugador;

public interface Usable {
	
	public void utilizar(Jugador jugador);
	
	public char getLetra();
	
	public TipoUsable getTipo();
	
	public int getCosto();	
}
