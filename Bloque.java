package tp;

public interface Bloque {
	public enum tipoDeMineral{COBRE,BRONCE,PLATA,ORO,HIERRO,DIAMANTE};
	public tipoDeMineral getTipo();
	public int getPrecio();
	public char getLetra();
}
