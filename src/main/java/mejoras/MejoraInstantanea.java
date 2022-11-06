package mejoras;

import jugador.Jugador;

public abstract class MejoraInstantanea {
	public int cantidadAMejorar;
	public int valor;
	
	public abstract void utilizar(Jugador jugador);
	
	public abstract int getValor();
}
