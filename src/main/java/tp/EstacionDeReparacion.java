package tp;

public class EstacionDeReparacion implements EstacionDeMantenimiento {
	public Posicion posicion;
	private static final int PRECIO_REPARACION = 10;
	
	public EstacionDeReparacion(int tamanioTerreno) {
		this.posicion.set((int)(tamanioTerreno * 0.8),0);
	}
	
	public void vender(Jugador jugador) {
		
	}
}
