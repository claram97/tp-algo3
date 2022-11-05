package tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EstacionDeServicioTest {

	@Test
	public void llenarTanque() {
		Jugador jugador = new Jugador(5, 0);
		jugador.nivelCombustible = 0;
		jugador.dinero = 100;
		var estacion = new EstacionDeServicio(10);
		//100 por ahora significa llenar el tanque, no 100 litros.
		estacion.vender(jugador, 100);
		
		assertEquals(10, jugador.getNivelCombustible());
		
	}
	
	@Test
	public void cargarCombustible() {
		Jugador jugador = new Jugador(5, 0);
		jugador.nivelCombustible = 0;
		jugador.dinero = 100;
		var estacion = new EstacionDeServicio(10);
		estacion.vender(jugador, 5);
		boolean naftaCorrecta = (jugador.getNivelCombustible() == 5);
		boolean plataCorrecta = (jugador.dinero == 95);
		
		assertTrue(naftaCorrecta && plataCorrecta);
	}
	
	@Test
	public void cargarSinDinero() {
		Jugador jugador = new Jugador(5, 0);
		jugador.nivelCombustible = 0;
		jugador.capacidadTanque = 10;
		jugador.dinero = 0;
		
		var estacion = new EstacionDeServicio(10);
		estacion.vender(jugador, 10);
		
		boolean naftaCorrecta = (jugador.getNivelCombustible() == 0);
		boolean plataCorrecta = (jugador.dinero == 0);
		
		assertTrue(naftaCorrecta && plataCorrecta);
	}
	
	@Test
	//No se si el juego deberia cargar 3 o directamente no cargar como hace ahora
	public void cargarSinSuficienteDinero() {
		Jugador jugador = new Jugador(5, 0);
		jugador.nivelCombustible = 0;
		jugador.capacidadTanque = 10;
		jugador.dinero = 3;
		
		var estacion = new EstacionDeServicio(10);
		estacion.vender(jugador, 10);
		
		boolean naftaCorrecta = (jugador.getNivelCombustible() == 0);
		boolean plataCorrecta = (jugador.dinero == 3);
		
		assertTrue(naftaCorrecta && plataCorrecta);
	}
	
	@Test
	public void cargarCantidadNoValida() {
		Jugador jugador = new Jugador(5, 0);
		jugador.nivelCombustible = 1;
		jugador.capacidadTanque = 10;
		jugador.dinero = 100;
		
		var estacion = new EstacionDeServicio(10);
		estacion.vender(jugador, 33);
		
		boolean naftaCorrecta = (jugador.getNivelCombustible() == 1);
		boolean plataCorrecta = (jugador.dinero == 100);
		
		assertTrue(naftaCorrecta && plataCorrecta);
	}
	

}