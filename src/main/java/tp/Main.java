package tp;

public class Main {
	public static final int ALTURA = 20;
	public static final int ANCHO = 20;

	public static void main(String[] args) {
		Terreno terreno = new Terreno(ALTURA, ANCHO);
		Jugador pj = new Jugador(ANCHO);
		Juego juego = new Juego(terreno, pj);
		juego.gameLoop();
	
	}

}
