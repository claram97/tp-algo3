package mejoras;

import static org.junit.Assert.*;

import org.junit.Test;

import jugador.Jugador;

public class MejoraMaxVidaTest {

	@Test
	public void mejoraCorrectamente() {
		Jugador pj = new Jugador(5, 0, 0, 0);
		int capacidadNueva = 80;
		var mejora = new MejoraMaxVida(capacidadNueva, 100);
		mejora.utilizar(pj);
		assertEquals(pj.getMaxHP(), capacidadNueva);
	}
	
	@Test
	public void noAceptaNegativos() {
		Jugador pj = new Jugador(5, 0, 0, 0);
		int capacidadNueva = -80;
		var mejora = new MejoraMaxVida(capacidadNueva, 100);
		int capacidadVieja = pj.getMaxHP();
		mejora.utilizar(pj);
		assertEquals(pj.getMaxHP(), capacidadVieja);
	}
	
	@Test
	public void noAchicaElInventario() {
		Jugador pj = new Jugador(5, 0, 0, 0);
		int capacidadNueva = 5;
		var mejora = new MejoraMaxVida(capacidadNueva, 100);
		int capacidadVieja = pj.getMaxHP();
		mejora.utilizar(pj);
		assertEquals(pj.getMaxHP(), capacidadVieja);
	}
}
