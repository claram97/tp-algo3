package tp.Mejoras;

import tp.Jugador;

public class MejoraHullRepairNanobots implements Usable {
	public static int VALOR = 7500;
	private static int VIDA_REGENERADA = 30;
	public static char LETRA = 'R';
	
	public MejoraHullRepairNanobots() {

	}
	
	public void utilizar(Jugador jugador) {
		jugador.agregarHP(MejoraHullRepairNanobots.VIDA_REGENERADA);
		jugador.hacerCompra(MejoraHullRepairNanobots.VALOR);
	}

	@Override
	public char getLetra() {
		return LETRA;
	}

	@Override
	public TipoUsable getTipo() {
		return TipoUsable.REPAIR;
	}
	
}
