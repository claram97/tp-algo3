package mejoras;

import jugador.Jugador;

public class MejoraHullRepairNanobots implements Usable {
	public static int VALOR = 7500;
	private static int VIDA_REGENERADA = 30;
	public static char LETRA = 'R';
	
	public MejoraHullRepairNanobots() {

	}
	
	public void utilizar(Jugador jugador) {
		jugador.getNave().repararDmg(MejoraHullRepairNanobots.VIDA_REGENERADA);
	}

	@Override
	public char getLetra() {
		return LETRA;
	}

	@Override
	public TipoUsable getTipo() {
		return TipoUsable.REPAIR;
	}

	@Override
	public int getCosto() {
		return VALOR;
	}
	
}
