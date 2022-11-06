package tp;

public class Main {
	public static final int ALTURA = 30;
	public static final int ANCHO = 20;

	public static void main(String[] args) {
		Suelo suelo = new Suelo(ALTURA, ANCHO);
		ConfigPisoSuperior config = new ConfigPisoSuperior();
		PisoSuperior pisoSuperior = new PisoSuperior(config);
		Jugador pj = new Jugador(5, 0,ALTURA,ANCHO);
		Juego juego = new Juego(suelo, pisoSuperior, pj);
		System.out.println("El juego está a punto de comenzar...");
		juego.gameLoop();
	}

}
