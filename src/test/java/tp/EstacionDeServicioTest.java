package tp;

import static org.junit.Assert.*;

import org.junit.Test;

public class EstacionDeServicioTest {

	@Test
	public void cargarCombustible() {
		Jugador jugador = new Jugador(5, 0);
		jugador.nivelCombustible = 0;
		jugador.dinero = 100;
		var estacion = new EstacionDeServicio(10);
		estacion.interactuar(jugador);
		
	}

}
