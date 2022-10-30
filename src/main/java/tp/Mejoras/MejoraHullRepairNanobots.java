package tp.Mejoras;

import tp.Jugador;

public class MejoraHullRepairNanobots extends MejoraDeJugador {
	public static int VALOR = 7500;
	private static int VIDA_REGENERADA = 30;
	public static char LETRA = 'R';
	
	public MejoraHullRepairNanobots() {
		super.letra = MejoraHullRepairNanobots.LETRA;
	}
	
	public void utilizar(Jugador jugador) {
		jugador.setHP(MejoraHullRepairNanobots.VIDA_REGENERADA);
		jugador.pagar(MejoraHullRepairNanobots.VALOR);
	}
	
}
