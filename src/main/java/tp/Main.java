package tp;

public class Main {
	public static final int ALTURA = 20;
	public static final int ANCHO = 20;

	public static void main(String[] args) {
		Suelo suelo = new Suelo(ALTURA, ANCHO);
		var ypf = new EstacionDeServicio(ANCHO);
		var mecanico = new EstacionDeReparacion(ANCHO);
		var tiendita = new TiendaDeMejoras(ANCHO);
		var tiendaConsumibles = new TiendaDeConsumibles(ANCHO);
		PisoSuperior tiendas = new PisoSuperior(ANCHO, ypf, mecanico, tiendita, tiendaConsumibles);
		Jugador pj = new Jugador(5, 0);
		Juego juego = new Juego(suelo, tiendas, pj);
		System.out.println("Holaaaaaaa");
		juego.gameLoop();
	}

}
