package tp;

public interface Entidad {
	public void interactuar(Jugador jugador);
	
	public Posicion getPosicion();
	
	public TipoEntidad getTipoEntidad();
	
	public char getLetra();
}
