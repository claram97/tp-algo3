package jugador;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import terreno.ConfigSuelo;
import terreno.Suelo;
import terreno.Suelo1;

public class AccionMovimientoTest {
	@Test
	public void MovimientoIzquierda() {
		Jugador jugador = new Jugador(5, 0,10,10);
		int vieja = jugador.getPosicion().getX();
		ConfigSuelo configSuelo = new Suelo1(10,10);
		Suelo suelo = new Suelo(configSuelo);
		AccionMovimiento mov = new AccionMovimiento(jugador, suelo, null, -1, 0);
		mov.aplicar();
		int nueva = jugador.getPosicion().getX();
		assertEquals(nueva, vieja - 1);
	}
	
	@Test
	public void MovimientoDerecha() {
		Jugador jugador = new Jugador(5,0,10,10);
		int vieja = jugador.getPosicion().getX();
		ConfigSuelo configSuelo = new Suelo1(10,10);
		Suelo suelo = new Suelo(configSuelo);
		AccionMovimiento mov = new AccionMovimiento(jugador, suelo, null, 1, 0);
		mov.aplicar();
		int nueva = jugador.getPosicion().getX();
		assertEquals(nueva, vieja + 1);
	}
	
	@Test
	public void MovimientoAbajo() {
		Jugador jugador = new Jugador(5,0,10,10);
		int vieja = jugador.getPosicion().getY();
		ConfigSuelo configSuelo = new Suelo1(10,10);
		Suelo suelo = new Suelo(configSuelo);
		AccionMovimiento mov = new AccionMovimiento(jugador, suelo, null, 0, 1);
		mov.aplicar();
		int nueva = jugador.getPosicion().getY();
		assertEquals(nueva, vieja + 1);
	}
	
	@Test
	public void MovimientoArriba() {
		Jugador jugador = new Jugador(5,1,10,10);
		int vieja = jugador.getPosicion().getY();
		ConfigSuelo configSuelo = new Suelo1(10,10);
		Suelo suelo = new Suelo(configSuelo);
		AccionMovimiento mov = new AccionMovimiento(jugador, suelo, null, 0, -1);
		mov.aplicar();
		int nueva = jugador.getPosicion().getY();
		assertEquals(nueva, vieja - 1);
	}
	
	@Test
	public void MovimientoArribaConBloque() {
		Jugador jugador = new Jugador(5,2,10,10);
		int vieja = 2;
		ConfigSuelo configSuelo = new Suelo1(10,10);
		Suelo suelo = new Suelo(configSuelo);
		AccionMovimiento mov = new AccionMovimiento(jugador, suelo, null, 0, -1);
		mov.aplicar();
		assertEquals(vieja, jugador.getPosicion().getY());
	}
	
	@Test
	public void Caer() {
		Jugador jugador = new Jugador(5,0,10,10);
		ConfigSuelo configSuelo = new Suelo1(10,10);
		Suelo suelo = new Suelo(configSuelo);
		suelo.destruirBloque(new Posicion(5, 1));
		suelo.destruirBloque(new Posicion(5, 2));
		suelo.destruirBloque(new Posicion(5, 3));
		AccionMovimiento mov = new AccionMovimiento(jugador, suelo, null, 0, 1);
		mov.aplicar();
		assertTrue(jugador.getPosicion().esPosicionIgual(new Posicion(5, 3)));
		
	}
	
	@Test
	public void Taladrar() {
		
	}
	
}