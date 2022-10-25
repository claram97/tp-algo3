package tp;

public class Main {

	public static void main(String[] args) {
		Terreno terreno = new Terreno();
		Jugador pj = new Jugador(10);

		Juego juego = new Juego(terreno, pj);
		
		juego.gameLoop();
	
	}

}
