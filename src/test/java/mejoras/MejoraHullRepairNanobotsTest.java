package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.Jugador;

public class MejoraHullRepairNanobotsTest {

	@Test
	public void sumaVida() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.setHP(1);
		var mejora = new MejoraHullRepairNanobots();
		mejora.utilizar(jugador);
		assertEquals(jugador.getHp(), jugador.getMaxHP());
	}
	
	public void sumaCorrectamente() {
		Jugador jugador = new Jugador(5, 0, 10, 10);
		jugador.setHP(1);
		jugador.setMaxHP(100);
		var mejora = new MejoraHullRepairNanobots();
		mejora.utilizar(jugador);
		assertEquals(jugador.getHp(), 31);
	}

}
